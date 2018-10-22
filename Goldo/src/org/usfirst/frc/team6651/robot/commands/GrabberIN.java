package org.usfirst.frc.team6651.robot.commands;

import org.usfirst.frc.team6651.robot.Robot;
import org.usfirst.frc.team6651.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class GrabberIN extends Command {
    
	public GrabberIN() {
    		requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		// System.out.println("Direction: " + direction);
    		Robot.grabber.grabber_move(RobotMap.CUBE_IN);    			
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		Robot.grabber.grabber_stop();
    }
}