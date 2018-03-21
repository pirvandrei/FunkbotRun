package SyncMotors;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Remote.RemoteCarClient;
import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.subsumption.Behavior;

public class BehaviourRemote extends Thread implements Behavior {

	
	private boolean suppressed = false;
	public static final int port = 7360;
	private Socket client;
	private static boolean looping = true;
	private static ServerSocket server;
	private static Thread t;
	//private static EV3MediumRegulatedMotor A = new EV3MediumRegulatedMotor(MotorPort.A);
	private static EV3LargeRegulatedMotor A = new EV3LargeRegulatedMotor(MotorPort.A);
	private static EV3LargeRegulatedMotor B = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public BehaviourRemote() throws IOException {
		server = new ServerSocket(7360);
		System.out.println("Awaiting client.."); 
		this.client = server.accept();
		Button.ESCAPE.addKeyListener(new EscapeListener());  
		t = new Thread ();
	} 
	 
	public boolean takeControl() { 
		return looping;
	} 
	  
	public void suppress() {
		while(looping) Thread.yield();
	}
	public void action() {
		t.start(); 
	}
	
	
	public void GetAction(int command) {
		switch(command) {
		case RemoteCarClient.BACKWARD:
			B.rotate(-360, true);
			A.rotate(-360);
			break;
		case RemoteCarClient.FORWARD:
			B.rotate(360, true);
			A.rotate(360);
			break;
		case RemoteCarClient.STRAIGHT:
			A.rotateTo(0);
			break;
		case RemoteCarClient.RIGHT:
			A.rotateTo(-170);
			break;
		case RemoteCarClient.LEFT:
			A.rotateTo(170);
			break;
		}
	}
	
	public void run() {
		System.out.println("CLIENT CONNECT");
		try {
			InputStream in = client.getInputStream();
			DataInputStream dIn = new DataInputStream(in);
			
			while(client != null) {
				int command = dIn.readInt();
				System.out.println("REC:" + command);
				if(command == RemoteCarClient.CLOSE) {
					client.close();
					client = null;
				} else {
					GetAction(command);
				}
			}
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
	private class EscapeListener implements KeyListener {
		
		public void keyPressed(Key k) {
			looping = false;
			System.exit(0);
		}

		public void keyReleased(Key k) {}
		}



	
	



	
}
