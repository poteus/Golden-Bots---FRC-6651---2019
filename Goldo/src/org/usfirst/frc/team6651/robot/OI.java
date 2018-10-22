package org.usfirst.frc.team6651.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6651.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI 
{

	public Joystick DriverJoystick = new Joystick(RobotMap.DRIVER_USB_PORT_0);
	public Joystick ActuatorJoystick = new Joystick(RobotMap.ACTUATOR_USB_PORT_1);
		
	public Button Trigger_Left_2 = new JoystickButton(DriverJoystick, 5);
	public Button Trigger_Right_2 = new JoystickButton(DriverJoystick, 6);
	public Button POV_Up = new JoystickButton(DriverJoystick, 4);
	public Button POV_Down = new JoystickButton(DriverJoystick, 2);

	public OI()
	{
		POV_Up.whileHeld(new ElevatorUP());
		POV_Down.whileHeld(new ElevatorDOWN());
		Trigger_Left_2.whileHeld(new GrabberIN());
		Trigger_Right_2.whileHeld(new GrabberOUT());
	}
}
