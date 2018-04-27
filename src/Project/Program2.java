package Project;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

import java.io.IOException;
import java.net.Socket;

import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort; 

public class Program2 {
	//static Arbitrator arby;
	private static Socket client;  
	public static void main(String[] args) throws IOException {
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		InfraredAdapter ir = new InfraredAdapter();
		ColorAdapter ca = new ColorAdapter();
		
		
		Behavior b1 = new BehaviourForward(leftMotor,rightMotor); 
		Behavior b2 = new BehaviourNavigateMaze(leftMotor,rightMotor,ir);
		Behavior b3 = new BehaviourStopByTouch(); 
		Behavior b4 = new BehaviourLineFollow(leftMotor, rightMotor, ca);
		Behavior[] b1b2b3 = {b1,b3,b2,b4};
		Arbitrator arby = new Arbitrator(b1b2b3);
		arby.go();
	}
	
}







//Behavior b4 = new BehaviourRemoteCarServer(leftMotor,rightMotor);
