package Maze;

//import lejos.hardware.motor;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.mapping.*; 
import lejos.robotics.navigation.*;

//draw a map
public class Ev3Agent {
	 

	public static void main(String[] args) throws Exception
	{
		Wheel wheelL = WheeledChassis.modelWheel(Motor.A, 37).offset(-72.5);
		Wheel wheelR = WheeledChassis.modelWheel(Motor.B, 37).offset(72.5);
	  
	  	Chassis chassis = new WheeledChassis(new Wheel[] { wheelL, wheelR }, WheeledChassis.TYPE_DIFFERENTIAL);

	  	MovePilot robot = new MovePilot(chassis); 
		robot.setAngularAcceleration(500);
		
		Navigator navigator = new Navigator(robot);
		
		Pose start = new Pose(17, 97, 0);
		navigator.getPoseProvider().setPose(start);
		
		EV3NavigationModel model = new EV3NavigationModel();
		model.addPilot(robot);
		model.addNavigator(navigator);
		model.addPoseProvider(navigator.getPoseProvider());
		 
	}
	
	
	
	
	
//	DifferentialPilot robot = new DifferentialPilot(5.6,16.4,Motor.A,Motor.B);
//	
//	
//	Wheel wheel1 = DifferentialChassis.modelWheel(Motor.A, 43.2).offset(-72);
//	Wheel wheel2 = DifferentialChassis.modelWheel(Motor.B, 43.2).offset(72);
//	 Chassis chassis = new DifferentialChassis(new Wheel[]{wheel1, wheel2}); 
//	 MovePilot pilot = new MovePilot(chassis);
//	 
}
