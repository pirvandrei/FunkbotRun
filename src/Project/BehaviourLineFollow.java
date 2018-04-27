package Project;

import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class BehaviourLineFollow implements Behavior {
	private boolean suppressed = false;
	private boolean foundLine = false;
	ColorAdapter colorSensor;
	boolean surpressed = false; 

	RegulatedMotor leftMotor;
	RegulatedMotor rightMotor;

	public BehaviourLineFollow(RegulatedMotor left, RegulatedMotor right, ColorAdapter ca) {
		this.leftMotor = left;
		this.rightMotor = right;
		this.colorSensor = ca; 
	}

	@Override
	public boolean takeControl() {
		System.out.println("Ask control:" + colorSensor.getColorIntensity());
		return colorSensor.getColorIntensity() > 0.20;
	}

	@Override
	public void action() {
		suppressed = false;
		foundLine = false;
		int speed = 500;
		int count = 0;
		System.out.println("Shit robot got before while");
		
		while(!suppressed) {
			if (colorSensor.getColorIntensity() > 0.20 && colorSensor.getColorIntensity() < 0.35) {
				
				if (!foundLine) {
					System.out.println("turning right, on white tape, with inssity:" + colorSensor.getColorIntensity());
//					leftMotor.stop();
//					rightMotor.stop();

					
					leftMotor.setSpeed(speed/2);
					rightMotor.setSpeed(speed/2/4);

//					leftMotor.forward();
//					rightMotor.forward();

					foundLine = true;
				}
			} else if(colorSensor.getColorIntensity() < 0.20) {
				if (foundLine) {
					System.out.println("turning right, on white tape, with inssity:" + colorSensor.getColorIntensity());
//					leftMotor.stop();
//					rightMotor.stop();

					leftMotor.setSpeed(speed/2/4);
					rightMotor.setSpeed(speed/2);

//					leftMotor.forward();
//					rightMotor.forward();

					foundLine = false;
				}
				System.out.println("turn nr: " + count + " just passed");
				count++;
				
				if (colorSensor.getColorIntensity() > 0.35) {	
					suppressed = true; 
				}
		}
		

			//suppressed = true;
			// if (colorSensor.getColorState() == Color.BLACK) {
			// suppressed = true;
			// }
		}
	}

	@Override
	public void suppress() {
		while (suppressed)
			Thread.yield();
	}

}