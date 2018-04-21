package Samples;

import Project.InfraredAdapter;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.SampleProvider;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;

public class LineFollower {

	public static void main(String[] args) {

		EV3 ev3 = (EV3) BrickFinder.getLocal();
		TextLCD lcd = ev3.getTextLCD();
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		SensorMode color = colorSensor.getColorIDMode();

		float[] sample = new float[color.sampleSize()];

		leftMotor.setSpeed(200);
		rightMotor.setSpeed(200);
		color.fetchSample(sample, 0);

		int colorId = (int) sample[0];
		String colorName = "";

		while (!Button.ESCAPE.isDown()) {
			switch (colorId) {
			case Color.WHITE:
				 
				leftMotor.forward();  
				colorName = "WHITE";
				break;
			case Color.BLACK:
				 
					rightMotor.forward();
				 
				colorName = "BLACK";
				break;
			}
		}
		lcd.drawString(colorId + " - " + colorName, 0, 0);

	}

}