package Project;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

// Taken from Bagnall p. 273.
// - very badly designed code as it anticipates priority :/
//   and depends on assumptions about other behaviours' internal matters:
//    -- it works only because any other b. calls commands for both motors

public class BehaviourForward implements Behavior {
//	RegulatedMotor leftMotor;
//	RegulatedMotor rightMotor;
	MovePilot pilot;
	
	
//	public BehaviourForward(RegulatedMotor left, RegulatedMotor right) {
//		this.leftMotor = left; this.rightMotor = right;
//	}
	public BehaviourForward(MovePilot MPilot) {
		this.pilot = MPilot; 
		
	}
	
	public boolean takeControl() {
		return true;
	}

	public void action() {
		 
		pilot.setLinearSpeed(100);
		pilot.setAngularSpeed(45);
		pilot.forward();
	}

	public void suppress() {
		// nothing to do
	}

}
