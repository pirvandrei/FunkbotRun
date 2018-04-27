package Project;

import lejos.robotics.subsumption.Behavior;

public class BehaviourNavigateMaze implements Behavior {
	SteeringController sc;
	InfraredAdapter irAdapter;
	boolean surpressed = false;

	public BehaviourNavigateMaze(SteeringController sc, InfraredAdapter irA) {
		this.sc = sc;
		this.irAdapter = irA;
	}

	@Override
	public boolean takeControl() {
		return irAdapter.objectDistance < 22;
	}

	@Override
	public void action() {
		surpressed = true;
		sc.turn(90);
		if (irAdapter.objectDistance < 50) {
			sc.turn(180);
		}
		surpressed = false;
	}

	@Override
	public void suppress() {
		while (surpressed)
			Thread.yield();
	}
}
