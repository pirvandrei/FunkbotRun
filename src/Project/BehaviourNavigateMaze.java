package Project;
 
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
 
public class BehaviourNavigateMaze implements Behavior {
	RegulatedMotor leftMotor;
	RegulatedMotor rightMotor;
	InfraredAdapter irAdapter;
    boolean surpressed=false;
	
	public BehaviourNavigateMaze(RegulatedMotor left, RegulatedMotor right, InfraredAdapter irA) {
		this.leftMotor = left; this.rightMotor = right; this.irAdapter=irA;
		this.leftMotor.setSpeed(200); 
		this.rightMotor.setSpeed(200); 
	}

	@Override
	public boolean takeControl() {
		return irAdapter.objectDistance < 22;  
	}

	
	//rotate 90 degree on 1st wall, 180 on second wall
	@Override
	public void action() {
		surpressed=true;  
	
		leftMotor.rotate(255,true); rightMotor.rotate(-255); 
		if(irAdapter.objectDistance < 50)
		{
			leftMotor.rotate(500,true); rightMotor.rotate(-500);
		} 
		surpressed=false;
	}

	@Override
	public void suppress() {
		while(surpressed) Thread.yield();
	} 
}
