package Samples;

import BehavioursRevisedjavaFiles.InfraredAdapter;
import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

import lejos.robotics.subsumption.Behavior;

public class MazeNavigator {
	public static void main(String[] args) {
	
	 
	 InfraredAdapter ir = new InfraredAdapter();
	 RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	 RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
	
	 EV3 ev3 = (EV3) BrickFinder.getLocal();
	 Keys keys = ev3.getKeys();
	 	
	 leftMotor.forward();
	 rightMotor.forward();
	  
	 
	 
	 
	 if	(ir.objectDistance < 10)
	 {
		leftMotor.stop();
	 	rightMotor.stop(); 
	 } 
	 
	 
	keys.waitForAnyPress();
	  
}
}