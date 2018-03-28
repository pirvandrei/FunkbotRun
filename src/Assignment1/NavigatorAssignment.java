package Assignment1;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.*;
public class NavigatorAssignment{
  public static void main(String[] args){
    
	  
	  Wheel wheelL = WheeledChassis.modelWheel(Motor.A, 37).offset(-45.5);
	  Wheel wheelR = WheeledChassis.modelWheel(Motor.B, 37).offset(45.5);
	  
	  Chassis chassis = new WheeledChassis(new Wheel[] { wheelL, wheelR }, WheeledChassis.TYPE_DIFFERENTIAL);
 
	  MovePilot pilot = new MovePilot(chassis); 
	  
	  pilot.setLinearSpeed(100);
	  pilot.setAngularSpeed(45);
	  
	  Navigator navigator = new Navigator(pilot);
	  
	 
	  navigator.goTo(500,500); 
	  try { Thread.sleep(500); } catch(Exception e) {}
	   
	  navigator.rotateTo(90);
	  try { Thread.sleep(500); } catch(Exception e) {} 

	  navigator.goTo(200,200); 
	  try { Thread.sleep(500); } catch(Exception e) {}
	   
	  navigator.rotateTo(-90);
	  try { Thread.sleep(500); } catch(Exception e) {}
	  
	  
	  navigator.goTo(500,250); 
	  
	  /*
	   * Test slack
	  navigator.addWaypoint(new Waypoint(0, 200));
      navigator.addWaypoint(new Waypoint(200, 100));
      navigator.addWaypoint(new Waypoint(0, 100));
      navigator.addWaypoint(new Waypoint(0,0));  
      navigator.followPath();*/
      
      Button.ENTER.waitForPressAndRelease();
	  /*
    
	  Navigator robot = new Navigator(pilot);
	  
	  robot.goTo(500,500); 
	  try { Thread.sleep(500); } catch(Exception e) {}
      
	  robot.rotateTo(90);
	  
	  robot.addWaypoint(new Waypoint(500,500));
	  robot.goTo(0,0);
	  while(robot.isMoving()) Sound.pause(500);
	  robot.rotateTo(0);*/
}  }
