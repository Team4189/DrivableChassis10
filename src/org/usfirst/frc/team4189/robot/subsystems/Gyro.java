package org.usfirst.frc.team4189.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends SerialPort {
    
  

	public Gyro(int baudRate, Port port) {
		super(baudRate, port);
		// TODO Auto-generated constructor stub
	}
	
	public Gyro(int baudRate, Port port, int dataBits) {
		super(baudRate, port, dataBits);
		// TODO Auto-generated constructor stub
	}

    public Gyro(int baudRate, Port port, int dataBits, Parity parity) {
	super(baudRate, port, dataBits, parity);
	// TODO Auto-generated constructor stub

    }
    
	public Gyro(int baudRate, Port port, int dataBits, Parity parity, StopBits stopBits) {
		super(baudRate, port, dataBits, parity, stopBits);
		// TODO Auto-generated constructor stub
	}
	//baudRate:  19200
	//port 
	//dataBits: 8
	//Parity: 0
	//stopbits: 1
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

   
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

