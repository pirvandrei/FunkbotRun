package Project;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class SteeringController {

	RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A); 
	
	public final int SPEED = 400;
	public final int QUARTER_OF_CIRCLE = 250;

	public SteeringController() {
		
		
	}
	
	public void turn(int degrees)
	{
		int quarters = degrees/90; 
		leftMotor.setSpeed(SPEED/2);
		rightMotor.setSpeed(SPEED/2); 
		leftMotor.rotate(QUARTER_OF_CIRCLE*quarters, true);
		rightMotor.rotate(-(QUARTER_OF_CIRCLE*quarters)); 
	}
	
	public void turnLeft()
	{
		leftMotor.setSpeed(SPEED / 2 / 4);
		rightMotor.setSpeed(SPEED / 2 );
	}
	
	public void turnRight()
	{
		leftMotor.setSpeed(SPEED / 2);
		rightMotor.setSpeed(SPEED / 2 / 4);
	}
	
	public void moveForward()
	{ 
		leftMotor.setSpeed(SPEED/2);
		rightMotor.setSpeed(SPEED/2);
		leftMotor.forward();
		rightMotor.forward();
	}
	
}
