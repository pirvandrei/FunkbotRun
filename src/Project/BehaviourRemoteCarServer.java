package Project;

import java.io.*;
import java.net.*;
import lejos.hardware.*;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class BehaviourRemoteCarServer extends Thread implements Behavior {

	private boolean suppressed = false;
	public static final int port = 7360;
	private Socket client;
	private static boolean looping = true;
	private static ServerSocket server;
	private static Thread t;
	RegulatedMotor leftMotor;
	RegulatedMotor rightMotor;
//	private static EV3LargeRegulatedMotor A = new EV3LargeRegulatedMotor(MotorPort.A);
//	private static EV3LargeRegulatedMotor B = new EV3LargeRegulatedMotor(MotorPort.B);

	public BehaviourRemoteCarServer(RegulatedMotor left,RegulatedMotor right) throws IOException {
		this.rightMotor = left; this.rightMotor = right;  
		server = new ServerSocket(port);
		System.out.println("Awaiting client..");
		this.client = server.accept();
		Button.ESCAPE.addKeyListener(new EscapeListener());
		t = new Thread();
	}

	public boolean takeControl() {
		return looping;
	}

	public void suppress() {
		while (looping)
			Thread.yield();
	}

	public void action() {
		t.start();
	}

	public void GetAction(int command) {
		switch (command) {
		case RemoteCarClient.BACKWARD:
			rightMotor.rotate(-360, true);
			rightMotor.rotate(-360);
			break;
		case RemoteCarClient.FORWARD:
			rightMotor.rotate(360, true);
			rightMotor.rotate(360);
			break;
		case RemoteCarClient.STRAIGHT:
			rightMotor.rotateTo(0);
			break;
		case RemoteCarClient.RIGHT:
			rightMotor.rotateTo(-170);
			break;
		case RemoteCarClient.LEFT:
			rightMotor.rotateTo(170);
			break;
		}
	}

	public void run() {
		System.out.println("CLIENT CONNECT");
		try {
			InputStream in = client.getInputStream();
			DataInputStream dIn = new DataInputStream(in);

			while (client != null) {
				int command = dIn.readInt();
				System.out.println("REC:" + command);
				if (command == RemoteCarClient.CLOSE) {
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

		public void keyReleased(Key k) {
		}
	}
}