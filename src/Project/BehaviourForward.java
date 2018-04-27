package Project;

import lejos.robotics.subsumption.Behavior;

public class BehaviourForward implements Behavior {
	SteeringController sc;

	public BehaviourForward(SteeringController sc) {
		this.sc = sc;
	}

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		sc.moveForward();
	}

	@Override
	public void suppress() {
	}

}
