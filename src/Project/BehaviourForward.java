package Project;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior; 

public class BehaviourForward implements Behavior {
	RegulatedMotor leftMotor;
	RegulatedMotor rightMotor;
	
	public BehaviourForward(RegulatedMotor left, RegulatedMotor right) {
		this.leftMotor = left; this.rightMotor = right;
	}
	
	public boolean takeControl() {
		return true;
	}

	public void action() {
		leftMotor.forward();
		rightMotor.forward();
	}

	public void suppress() { 
	}

}
