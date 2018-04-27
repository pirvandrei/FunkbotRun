package Project;

import lejos.robotics.subsumption.Behavior;

public class BehaviourLineFollow implements Behavior {
	private boolean foundWhiteLine = false;
	private boolean surpressed = false;
	SteeringController sc;
	ColorAdapter ca;

	public BehaviourLineFollow(SteeringController sc, ColorAdapter ca) {
		this.sc = sc;
		this.ca = ca;
	}

	@Override
	public boolean takeControl() {
		return ca.getColorIntensity() > 0.25 && ca.getColorIntensity() < 0.51;
	}

	@Override
	public void action() {
		surpressed = true;
		foundWhiteLine = false;

		while (surpressed) {
			if (ca.getColorIntensity() > 0.25 && ca.getColorIntensity() < 0.51) {
				if (!foundWhiteLine) {
					sc.turnRight();
					foundWhiteLine = true;
				}
			} else if (ca.getColorIntensity() < 0.10) {
				if (foundWhiteLine) {
					sc.turnLeft();
					foundWhiteLine = false;
				}
			} 
			if (ca.getColorIntensity() >= 0.53) {
				foundWhiteLine = false;
				surpressed = false;
			}
		}
	}

	@Override
	public void suppress() {
		while (surpressed)
			Thread.yield();
	}
}