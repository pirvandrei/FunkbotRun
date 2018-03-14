package Assignment1;

import lejos.hardware.motor.Motor;

import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.*;

public class PilotAssignment{
  public static void main(String[] args){
	  
	  Wheel wheelL = WheeledChassis.modelWheel(Motor.A, 37).offset(-72.5);
	  Wheel wheelR = WheeledChassis.modelWheel(Motor.B, 37).offset(72.5);
	  
	  Chassis chassis = new WheeledChassis(new Wheel[] { wheelL, wheelR }, WheeledChassis.TYPE_DIFFERENTIAL);

	  MovePilot pilot = new MovePilot(chassis);
	  
	  
	  pilot.setLinearSpeed(100);
	  pilot.setAngularSpeed(45); 	// degrees per sec
      
      pilot.travel(500);
      try { Thread.sleep(500); } catch(Exception e) {}        
      
      pilot.arc(0, 90);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.travel(200);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.arc(-200, 90);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.travel(200);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.arc(-200, 90);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.travel(500);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.arc(0, -90);
      try { Thread.sleep(500); } catch(Exception e) {}
       
      pilot.travel(1000);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.arc(0,-90);
      try { Thread.sleep(500); } catch(Exception e) {}
       
      pilot.travel(300);
      try { Thread.sleep(500); } catch(Exception e) {}
       
      pilot.arc(0, -90);
      try { Thread.sleep(500); } catch(Exception e) {}
      
      pilot.stop();


	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  /*
	  pilot.setAngularSpeed(45); 	// degrees per sec
	  pilot.setLinearSpeed(100); 	// cm per sec
	 
	  //arc
	  pilot.travelArc(50,50);
	  
	  
	  pilot.travel(500);         	// cm
	  pilot.arc(0, 90);        	// degree 
	 
	  pilot.travel(500);         	// cm
	  pilot.arc(, 90);        	// degree 
	  
	  
	  /* 
	  pilot.travel(500);         	// cm
	  pilot.arc(0, 90);       	// degree 
	  
	  pilot.travel(500);         	// cm
	  pilot.arc(0, 90);       	// degree 
	  
	  pilot.travel(500);         	// cm
	  pilot.arc(0, 90);        	// degree 
	  */
	  
	 // pilot.arcForward(1.8); 			// radius, distance
//	  pilot.stop(); 
	  
	  
//	  pilot.travel(-100);  			// move backward 
//	  pilot.arc(100,40); 			// radius, degree
//	  pilot.travel(-80);  			// move backward 
//	  pilot.rotate(-13);        	// degree 
//	  pilot.stop();      
  }
}
