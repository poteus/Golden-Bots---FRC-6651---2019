package org.usfirst.frc.team6651.robot.subsystems;

import org.usfirst.frc.team6651.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	WPI_TalonSRX elevatorTalon = new WPI_TalonSRX(RobotMap.ELEVATOR_CIM);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new Elevator());
    }
	
    public void go_speed(double speed) {
    		elevatorTalon.set(speed);
    }
    
    public void stop() {
		elevatorTalon.set(0);
    }
    
    public void hold_position() {
		elevatorTalon.set(RobotMap.HoldSpeed);
    }
    
    public void elevator_up(double speed) {
		elevatorTalon.set(speed);
    }
    
    public void elevator_down(double speed) {
		elevatorTalon.set(-speed);
    }

}
