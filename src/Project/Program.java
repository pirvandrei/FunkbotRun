package Project;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

import java.io.IOException;
import java.net.Socket;

import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;

public class Program {
	//static Arbitrator arby;
	private static Socket client; 
	public static void main(String[] args) throws IOException {
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		Behavior b1 = new BehaviourForward(leftMotor,rightMotor);
		InfraredAdapter ir = new InfraredAdapter();
		Behavior b2 = new BehaviourNavigateMaze(leftMotor,rightMotor,ir);
		Behavior b3 = new BehaviourStopByTouch();
		Behavior b4 = new BehaviourRemoteCarServer(leftMotor,rightMotor);
		Behavior[] b1b2b3 = {b1,b2,b3,b4};
		Arbitrator arby = new Arbitrator(b1b2b3);
		arby.go();
	}
	
}
