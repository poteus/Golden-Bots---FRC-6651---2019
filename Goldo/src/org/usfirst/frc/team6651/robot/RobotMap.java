package org.usfirst.frc.team6651.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int Yaxis = 0;
	public static int Xaxis = 1;
	public static int Rotation = 2;
	public static int Throttle = 3;
	
	public static int UP = 1;
	public static int DOWN = -1;
	public static int CUBE_IN = 1;
	public static int CUBE_OUT = -1;
	public static int LEFT = -1;
	public static int RIGHT = 1;
	
	public static final int DRIVER_USB_PORT_0 = 0;
	public static final int ACTUATOR_USB_PORT_1 = 1;
	
	public static int DRIVETRAIN_TALON_LEFT_1 = 10;
	public static int DRIVETRAIN_TALON_LEFT_2 = 11;
	public static int DRIVETRAIN_TALON_RIGHT_1 = 12;
	public static int DRIVETRAIN_TALON_RIGHT_2 = 13;
	public static int SLIDE_TALON_RIGHT_1 = 14;
	public static int SLIDE_TALON_RIGHT_2 = 15;
	public static int GRABBER_TALON_1 = 16;
	public static int GRABBER_TALON_2 = 17;
	
	public static int ELEVATOR_CIM = 18;

	public static double defaultSpeed = 0.5;
	public static double HoldSpeed=0.2;
}	
	