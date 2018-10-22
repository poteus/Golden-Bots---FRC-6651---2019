/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6651.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public static DifferentialDrive DT;
	Spark slider;
	Joystick PS4 = new Joystick(0);
	Encoder RightEncoder;
	Encoder LeftEncoder;
	int countRight, previousRight;
	int countLeft, previousLeft;
	double ticks_per_inch=250;
	
	
	@Override
	public void robotInit() {
		Spark rightFront = new Spark(1);
		Spark rightBack = new Spark(2);
		SpeedControllerGroup m_right = new SpeedControllerGroup(rightFront, rightBack);
		Spark leftFront = new Spark(4);
		Spark leftBack = new Spark(5);
		SpeedControllerGroup m_left = new SpeedControllerGroup(leftFront, leftBack);
		m_left.setInverted(false);
		DT = new DifferentialDrive(m_right, m_left);	
		slider = new Spark(6);
		
		RightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		LeftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		RightEncoder.reset();
		LeftEncoder.reset();
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
		DT.tankDrive(-.6,-.6);
		RightEncoder.reset();
		LeftEncoder.reset();
		countRight = RightEncoder.get();
		countLeft = LeftEncoder.get();
		System.out.println("Right Encoder: " + countRight);
	}
	
	public int distance_reached(int encoder_value, double distance)
	{
		int reach = 0;
			if( encoder_value/ticks_per_inch>distance)
				reach = 1;
		return reach;
	}
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		countRight = RightEncoder.get();
		countLeft = LeftEncoder.get();
		if(distance_reached(countRight,5) == 1)
		{
			DT.tankDrive(0,0);
			System.out.println("Stop at: " + countLeft + " " + countRight);
		}
		else DT.tankDrive(-.65,-.65);
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		double left = PS4.getRawAxis(X_axis); 
		double right = PS4.getRawAxis(Y_axis); 
		DT.arcadeDrive(left,right);
		
		// double slideSpeed = PS4.getRawAxis(Rotation);
		// slider.set(slideSpeed);
		countRight = RightEncoder.get();
		countLeft = LeftEncoder.get();
		if(previousRight != countRight || previousLeft != countLeft)
		{
			System.out.println("Encoders: " + countRight + " " + countLeft);
			previousRight = countRight;
			previousLeft = countLeft;
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
