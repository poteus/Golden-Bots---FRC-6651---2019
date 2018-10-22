package org.usfirst.frc.team6651.robot.commands;

import org.usfirst.frc.team6651.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class ElevatorDOWN extends Command {
  
	Encoder ElevatorEncoder;
	double countElevator, Bottom=0;
	
	double Max_Speed = 1;
	
	public ElevatorDOWN() {
    		requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	countElevator = ElevatorEncoder.get();
		if(countElevator<(Bottom*0.9))
			Robot.elevator.elevator_down(Max_Speed);
		else if(countElevator<Bottom)
			Robot.elevator.elevator_down(Max_Speed/2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		/*if (direction == 1){
    			return Robot.elevator.isUp();
    		} 
    		else if (direction == -1){
    			return elevator.isDown();
    		} 
    		else 
    		{
    			return true;
    		}*/
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		Robot.elevator.stop();
    }
}