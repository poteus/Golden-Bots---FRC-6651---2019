/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6651.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public static DifferentialDrive DT;
	// Spark slider;
	Joystick PS4 = new Joystick(0);
	// int buttonButterflyId = 1;
	// Button butterflyButton = new JoystickButton(PS4, buttonButterflyId);
	Button butterflyButtonUp = new JoystickButton(PS4, 1);
	Button butterflyButtonDown = new JoystickButton(PS4, 2);
	
	WPI_TalonSRX talon10;
	WPI_TalonSRX talon11;
	WPI_TalonSRX talon12;
	WPI_TalonSRX talon13;
	
	Compressor c;
	DoubleSolenoid butterflySolenoid;
	boolean changeOfState = true;
	boolean butterflyState = false;

	// c.setClosedLoopControl(true);  // Start compressor control
	// c.setClosedLoopControl(false); // Stop compressor control
	// exampleSolenoid.set(true);  or  exampleSolenoid.set(false);
	
	@Override
	public void robotInit() {
		talon10 = new WPI_TalonSRX(10);
		talon12 = new WPI_TalonSRX(12);
		talon12.follow(talon10);
		talon11 = new WPI_TalonSRX(11);
		talon13 = new WPI_TalonSRX(13);
		talon13.follow(talon11);
		
		DT = new DifferentialDrive(talon10, talon11);
		
		c = new Compressor(0);
		c.setClosedLoopControl(true);  // Start compressor control
		
		butterflySolenoid = new DoubleSolenoid(0, 1);
		butterflySolenoid.set(DoubleSolenoid.Value.kForward);	
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
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		double forward = PS4.getRawAxis(X_axis); 
		double turn = PS4.getRawAxis(Y_axis); 
		DT.arcadeDrive(forward, -turn);
/*
		if (PS4.getRawButton(buttonButterflyId) == true && changeOfState == true) {
			System.out.println("Button pushed");
			if (butterflyState == false)
				butterflySolenoid.set(DoubleSolenoid.Value.kForward);
			else
				butterflySolenoid.set(DoubleSolenoid.Value.kReverse);
			butterflyState = !butterflyState;
			changeOfState = false;
		}
		if (PS4.getRawButton(buttonButterflyId) == false && changeOfState == false) {
			changeOfState = true;
		}*/
		
		if (PS4.getRawButton(1) == true) {
			butterflySolenoid.set(DoubleSolenoid.Value.kForward);
		}
		if (PS4.getRawButton(1) == false && PS4.getRawButton(2) == true) {
			butterflySolenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
