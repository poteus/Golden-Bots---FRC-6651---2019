package org.usfirst.frc.team6651.robot.subsystems;

import org.usfirst.frc.team6651.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
	
	WPI_TalonSRX grabberTalon1 = new WPI_TalonSRX(RobotMap.GRABBER_TALON_1);
	WPI_TalonSRX grabberTalon2 = new WPI_TalonSRX(RobotMap.GRABBER_TALON_2);
	double defaultSpeed=0.5;
 
    public void initDefaultCommand() {
    		grabberTalon2.follow(grabberTalon1);
        // Set the default command for a subsystem here.
        // setDefaultCommand(new Elevator());
    }
	
    public void grabber_move(double movement) {
    		grabberTalon1.set(movement*defaultSpeed);
    }
    
    public void grabber_stop() {
		grabberTalon1.set(0);
    }
}
