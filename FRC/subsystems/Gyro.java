/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GyroValues;

public class Gyro extends Subsystem {

  AHRS ahrs;

  public Gyro(){
    ahrs = new AHRS(SPI.Port.kMXP);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GyroValues());
  }

  public double GetPitch(){
    double pitch = ahrs.getPitch();
    
    return pitch; 
  }

  public double GetAngle(){
    double angle = ahrs.getAngle();
    return angle;
  }

  public double GetRoll(){
    double Roll = ahrs.getRoll();
    return Roll;
  }

  public double GetYaw(){
    double Yaw = ahrs.getYaw();
    return Yaw;
  }

  public void resetAhrs(){
    ahrs.reset();
  }
}
