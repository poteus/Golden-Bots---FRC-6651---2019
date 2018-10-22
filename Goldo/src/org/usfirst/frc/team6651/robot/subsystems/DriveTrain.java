package org.usfirst.frc.team6651.robot.subsystems;

import org.usfirst.frc.team6651.robot.Robot;
import org.usfirst.frc.team6651.robot.RobotMap;
import org.usfirst.frc.team6651.robot.commands.DriveTrain_SlideDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	// Talons and DriveTrain
	WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(RobotMap.DRIVETRAIN_TALON_LEFT_1);
	WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(RobotMap.DRIVETRAIN_TALON_LEFT_2);

	WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(RobotMap.DRIVETRAIN_TALON_RIGHT_1);
	WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(RobotMap.DRIVETRAIN_TALON_RIGHT_2);
	
	WPI_TalonSRX slideMotor1 = new WPI_TalonSRX(RobotMap.SLIDE_TALON_RIGHT_1);
	WPI_TalonSRX slideMotor2 = new WPI_TalonSRX(RobotMap.SLIDE_TALON_RIGHT_2);
	
	DifferentialDrive DT;

    public void initDefaultCommand() {
    		leftMotor2.follow(leftMotor1);
    		rightMotor2.follow(rightMotor1);
    		slideMotor2.follow(slideMotor1);
    		
    		DT = new DifferentialDrive(leftMotor1, rightMotor1);
    		
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrain_SlideDrive());
    }
	
    public void drive(double forward, double turn, double slide) {
    		Robot.driveTrain.DT.arcadeDrive(forward,turn);
    		Robot.driveTrain.slideMotor1.set(slide);
    		// system.out.println("Drive: " + forward + " " + turn + " " + slide);
    }
}
