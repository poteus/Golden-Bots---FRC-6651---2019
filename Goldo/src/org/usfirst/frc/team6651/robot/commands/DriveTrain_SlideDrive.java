package org.usfirst.frc.team6651.robot.commands;

import org.usfirst.frc.team6651.robot.Robot;
import org.usfirst.frc.team6651.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class DriveTrain_SlideDrive extends Command {
	
    public DriveTrain_SlideDrive() {
      requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    		double forward = Robot.oi.DriverJoystick.getRawAxis(RobotMap.Xaxis); 
    		double rotation = Robot.oi.DriverJoystick.getRawAxis(RobotMap.Rotation); 
    		double slideSpeed = Robot.oi.DriverJoystick.getRawAxis(RobotMap.Yaxis);
	
    		Robot.driveTrain.drive(-forward, rotation, slideSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    		Robot.driveTrain.drive(0, 0, 0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		Robot.driveTrain.drive(0, 0, 0);
    }
}