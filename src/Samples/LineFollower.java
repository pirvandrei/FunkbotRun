package Samples;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.Motor;
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

public class LineFollower {

   public static double P = 82;

   /**
    * This program uses one EV3 color sensor position in front of the robot to follow the line. The robot follow the right edge of a black line on
    * white paper. To calibrate, change P above or hold down the up and down buttons while the robot is moving. Then, use the up and down buttons to
    * set P and press enter when done.
    */
   public static void main(String[] args) {
   
//      new Thread("Stopper") {
//         
//         @Override
//         public void run() {
//
//            while (true)
//               if (Button.ESCAPE.isDown() && Button.ENTER.isDown())
//                  System.exit(0);
//         }
//      }.start();
      Wheel wheelL = WheeledChassis.modelWheel(Motor.A, 37).offset(-72.5);
	  Wheel wheelR = WheeledChassis.modelWheel(Motor.B, 37).offset(72.5);
	  
	  Chassis chassis = new WheeledChassis(new Wheel[] { wheelL, wheelR }, WheeledChassis.TYPE_DIFFERENTIAL);

      MovePilot pilot = new MovePilot(chassis);
      pilot.setLinearSpeed(.7);
////      EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S3);
////      SensorMode RGBMode = sensor.getColorIDMode();
//      
      	EV3 ev3 = (EV3) BrickFinder.getLocal();
		TextLCD lcd = ev3.getTextLCD();
		Keys keys = ev3.getKeys();
		
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		SensorMode color = colorSensor.getColorIDMode();
		float[] sample = new float[color.sampleSize()];
		color.fetchSample(sample, 0);
		int colorId = (int)sample[0];
		String colorName = "";
		switch(colorId){
			case Color.NONE: colorName = "NONE"; break;
			case Color.BLACK: colorName = "BLACK"; pilot.arc(0,10);
			case Color.BLUE: colorName = "BLUE"; break;
			case Color.GREEN: colorName = "GREEN"; break;
			case Color.YELLOW: colorName = "YELLOW"; break;
			case Color.RED: colorName = "RED"; break;
			case Color.WHITE: colorName = "WHITE"; pilot.arc(10,0);
			case Color.BROWN: colorName = "BROWN"; break;
		}
		lcd.drawString(colorId + " - " + colorName, 0, 0);
		keys.waitForAnyPress();
 
//      double white = -1.0; 
//      double black = 7.0; 
//      
//      while (Button.ESCAPE.isUp()) {
//         double error = 0;
//         if(RGBMode.sampleSize() == white) error = -1;
//         else if (RGBMode.sampleSize() == black) error = 1; 
//         pilot.rotate(P * error); 
//         
//      }
      
   }
   
   

}