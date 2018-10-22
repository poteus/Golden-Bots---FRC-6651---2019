/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6651.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	// public static DifferentialDrive DT;
	// Spark slider;
	// Joystick PS4 = new Joystick(0);
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	double angle;
	double tick_per_degree=0.000144114;
	
	
	@Override
	public void robotInit() {
		// Spark rightFront = new Spark(1);
		// Spark rightBack = new Spark(2);
		// SpeedControllerGroup m_right = new SpeedControllerGroup(rightFront, rightBack);
		// Spark leftFront = new Spark(4);
		// Spark leftBack = new Spark(5);
		// SpeedControllerGroup m_left = new SpeedControllerGroup(leftFront, leftBack);
		// m_left.setInverted(false);
		// DT = new DifferentialDrive(m_right, m_left);	
		// slider = new Spark(6);

        // gyro.calibrate();
        gyro.reset();
		// gyro.calibrate();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		// DT.tankDrive(0,0);
		// gyro.reset();
		gyro.calibrate();
	}
	
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		angle = gyro.getAngle();
		System.out.println("Angle at: " + angle + "    The angle: " + (int)(angle/tick_per_degree));
		// if((angle/tick_per_degree)>90)
		// {
		// 	DT.tankDrive(0,0);
		//	System.out.println("Stop at: " + angle);
		//}
		//else DT.tankDrive(.5,-.5);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		angle = gyro.getAngle();
		System.out.println("Angle at: " + angle + "    The angle: " + (int)(angle/tick_per_degree));
		// int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		// double forward = PS4.getRawAxis(X_axis); 
		// double turn = PS4.getRawAxis(Y_axis); 
		// DT.arcadeDrive(forward,turn);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
