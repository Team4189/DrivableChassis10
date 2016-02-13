package org.usfirst.frc.team4189.robot.subsystems;

import java.util.Arrays;

import org.usfirst.frc.team4189.robot.OI;
import org.usfirst.frc.team4189.robot.Robot;
import org.usfirst.frc.team4189.robot.RobotMap;
import org.usfirst.frc.team4189.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
	Talon rightMotor = new Talon(RobotMap.rightMotorPort);
	Talon leftMotor = new Talon(RobotMap.leftMotorPort);
	
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setSpeed(double x, double y){
		leftMotor.set(x*-1);
		rightMotor.set(y);
	}
    
	public double convert(){
		//conversion factor: 4.9mV/1cm
		//this is our best guess so far
		return OI.rangeFinder1.getVoltage()*83.961;
	    }
	
	public double gyroConvert(){
		if(OI.gyro.getAngle() < 360 && OI.gyro.getAngle() > -360){
			return OI.gyro.getAngle();
			
		}
		OI.gyro.reset();
		//return 0.0;
		return OI.gyro.getAngle();
		
		
	}
	 public void dashData(){
		 SmartDashboard.putNumber("Distance In Inches", convert());
		 SmartDashboard.putNumber("Gyro Acceleration" , OI.gyro.getRate());
		 SmartDashboard.putNumber("Gyro Angle", gyroConvert());
		 
	 }
	 
	 
	 public double compareRange(){
		 double minRange = 0.0;
	     double [] SwerveVs = new double[90];
	     for(int i = 0; i < 90; i++){
	            Robot.chassis.setSpeed(-0.25, 0.25);
	            SwerveVs[i] = Robot.chassis.convert();
	            Robot.chassis.setSpeed(0,0);
	      }
	      Arrays.sort(SwerveVs);
          minRange = SwerveVs[0];
	      Robot.chassis.setSpeed(0,0);
	      return minRange;

	    }
	    public void findMinRange(){

	    double minRange = compareRange();
	    while(Robot.chassis.convert() != minRange){
	        Robot.chassis.setSpeed(0.25, -0.25);
	        }
	        Robot.chassis.setSpeed(0,0);
	    }


    public void initDefaultCommand() {
       setDefaultCommand(new DriveWithJoysticks());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

