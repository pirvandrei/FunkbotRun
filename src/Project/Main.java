package Project;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;

public class Main { 
		public static void main(String[] args) {
	
			Wheel wheelL = WheeledChassis.modelWheel(Motor.A, 37).offset(-45.5);
			Wheel wheelR = WheeledChassis.modelWheel(Motor.B, 37).offset(45.5); 
			Chassis chassis = new WheeledChassis(
					new Wheel[] { wheelL, wheelR }, WheeledChassis.TYPE_DIFFERENTIAL);
 
			MovePilot pilot = new MovePilot(chassis);  
		
			  
			   
			  
//			RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
//			RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
			
			//Behavior b1 = new BehaviourForward(leftMotor,rightMotor); 
			Behavior b1 = new BehaviourForward(pilot); 
			InfraredAdapter ir = new InfraredAdapter();
			//Behavior b2 = new BehaviourAvoidObject(leftMotor,rightMotor,ir);
			Behavior b2 = new BehaviourAvoidObject(pilot,ir);
			
			Behavior b3 = new BehaviourStopByTouch();
			Behavior[] b1b2b3 = {b1,b2,b3};
			Arbitrator arby = new Arbitrator(b1b2b3);
			arby.go();
		}
	}
 
