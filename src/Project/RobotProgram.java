package Project;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import java.io.IOException;

public class RobotProgram {

	public static void main(String[] args) throws IOException {
		SteeringController steeringController = new SteeringController();
		InfraredAdapter infraredAdapter = new InfraredAdapter();
		ColorAdapter colorAdapter = new ColorAdapter();
		Behavior b4 = new BehaviourForward(steeringController);
		Behavior b3 = new BehaviourNavigateMaze(steeringController, infraredAdapter);
		Behavior b2 = new BehaviourLineFollow(steeringController, colorAdapter);
		Behavior b1 = new BehaviourStopByTouch();
		Behavior[] robotBehaviours = { b4, b3, b2, b1 };
		Arbitrator arby = new Arbitrator(robotBehaviours);
		arby.go();
	}
}
