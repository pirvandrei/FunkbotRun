package Project;

import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

// adapted from Bagnall p. 274
public class BehaviourAvoidObject implements Behavior {
//	RegulatedMotor leftMotor;
//	RegulatedMotor rightMotor;
	MovePilot pilot;
	InfraredAdapter irAdapter;
    boolean gotItRight=false;
	
//	public BehaviourAvoidObject(RegulatedMotor left, RegulatedMotor right, InfraredAdapter irA) {
//		this.leftMotor = left; this.rightMotor = right; this.irAdapter=irA;
//	}
    public BehaviourAvoidObject(MovePilot MPilot, InfraredAdapter irA) {
		this.pilot = MPilot; this.irAdapter=irA;
		pilot.setLinearSpeed(100);
		pilot.setAngularSpeed(45);
	}
    
	@Override
	public boolean takeControl() {
		return irAdapter.objectDistance < 25; // global variable
	}

	@Override
	public void action() {
		gotItRight=true; 
		gotItRight(pilot);
		gotItRight=false;
	}

	@Override
	public void suppress() {
		// The following from the book looks weird; not in accordance with the specification
		while(gotItRight) Thread.yield();
	}
	
	public void gotItRight(MovePilot pilot) {
		pilot.rotate(90); 
		if(irAdapter.objectDistance < 15) 
			pilot.rotate(180); 
	}
	

}
