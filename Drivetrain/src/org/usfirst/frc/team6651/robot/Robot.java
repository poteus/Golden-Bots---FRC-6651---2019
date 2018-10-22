package org.usfirst.frc.team6651.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	private Spark slider;
	
	public static DifferentialDrive DT;
	
	Joystick joy1 = new Joystick(1);
	Joystick joy2 = new Joystick(0);

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
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
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	
	@Override
	public void teleopPeriodic() {
		
		// Normal arcade with slide on throttle
		// int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		// double forward = joy1.getRawAxis(X_axis); 
    		// double turn = joy1.getRawAxis(Y_axis); 
    		// forward=0.4*forward+0.6*forward*forward*forward;
    		// turn=0.4*turn+0.6*turn*turn*turn;
		// DT.arcadeDrive(forward, turn);
		// double slideSpeed = joy1.getRawAxis(Throttle);
		// slideSpeed=0.4*slideSpeed+0.6*slideSpeed*slideSpeed*slideSpeed;
		// slider.set(slideSpeed);
		
		// Forward in Y_axis
		// Rotate in Z_axis rotation
		// Slide on X_axis
		// int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		// double forward = joy.getRawAxis(X_axis); 
    		// double turn = joy.getRawAxis(Rotation); 
		// DT.arcadeDrive(forward, turn);
		// double slideSpeed = joy.getRawAxis(Y_axis);
		// slider.set(slideSpeed);
		
		// 2 joystick drive
		// Joystick 1: Arcade drive
		// Joystick 2: Slide on X_axis
		//int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		//double forward = joy1.getRawAxis(X_axis); 
		//double turn = joy1.getRawAxis(Y_axis); 
		// forward=forward*forward*forward;
		// turn=turn*turn*turn;
		//DT.arcadeDrive(forward, turn);
		//double slideSpeed = joy2.getRawAxis(Y_axis);
		//slider.set(slideSpeed);
		
		// 2 joystick drive
		// Joystick 1 and 2: Tank drive
		// Joystick 2: Slide on X_axis
		int X_axis = 1, Y_axis = 0, Rotation = 2, Throttle = 3;
		double left = joy1.getRawAxis(X_axis); 
		double right = joy2.getRawAxis(X_axis); 
		DT.tankDrive(left,right);
		
		double slideSpeed = (joy1.getRawAxis(Y_axis)+joy2.getRawAxis(Y_axis))/2;
		slider.set(slideSpeed);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
}