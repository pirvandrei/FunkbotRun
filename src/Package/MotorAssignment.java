package Package;
import lejos.hardware.motor.Motor; 
import lejos.robotics.RegulatedMotor;

public class MotorAssignment{ 
	
	public static void main(String[] args){   
	goStraight(580, 580, 2);
	rotate(780, 0);  
	goStraight(200, 750, 2); 
	goStraight(580, 580, 1); 
	rotate(0, 780); 
	goStraight(580, 580, 3); 
	rotate(0, 780); 
	goStraight(580, 580, 1); 
	rotate(0, 780);
	}

	private static void rotate(int leftForward, int rightForward) {  
		try{Thread.sleep(1000);}catch(Exception e){} 
	    Motor.A.rotate(leftForward); 
	    Motor.B.rotate(rightForward); 	
	} 
	
	private static void goStraight(int speedA, int speedB, int sec) { 
	   RegulatedMotor[] syncList = {Motor.B}; 
	   Motor.A.synchronizeWith(syncList); 
	   Motor.A.setAcceleration(500);
	   Motor.B.setAcceleration(500); 
	   Motor.A.setSpeed(speedA);
	   Motor.B.setSpeed(speedB); 
	   Motor.A.startSynchronization();
	   Motor.A.forward();
	   Motor.B.forward();
	   Motor.A.endSynchronization(); 
	   try{Thread.sleep(sec*1000);}catch(Exception e){} 
	   Motor.A.startSynchronization();
	   Motor.A.stop();
	   Motor.B.stop();
	   Motor.A.endSynchronization(); 
	} 
}

 