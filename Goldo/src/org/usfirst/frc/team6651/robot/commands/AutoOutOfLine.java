	package org.usfirst.frc.team6651.robot.commands;

import org.usfirst.frc.team6651.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class AutoOutOfLine extends Command {
	
	// Encoders for distance
	Encoder RightEncoder;
	Encoder LeftEncoder;
	int countRight, previousRight;
	int countLeft, previousLeft;
	double ticks_per_inch=250;
	
	// Gyro to straight and turn
	ADXRS450_Gyro gyro;
	double angle;
	double kp=0.004;
	
	double DistanceToTravel = 5; // in feet


    public AutoOutOfLine() {
      requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		RightEncoder.reset();
		LeftEncoder.reset();
		// gyro.calibrate(); If Gyro does not reset
		gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    		countRight = RightEncoder.get();
		countLeft = LeftEncoder.get();
		
		if(distance(countRight) > DistanceToTravel)
		{
			Robot.driveTrain.drive(0, 0, 0);
		}
		drive_straight(.5);
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
    
    public void drive_straight(double speed) {
		angle = gyro.getAngle();
		Robot.driveTrain.drive(speed,-angle*kp,0);
    }
    
    public double distance(double count) {
    		return count/ticks_per_inch;
    }

}
