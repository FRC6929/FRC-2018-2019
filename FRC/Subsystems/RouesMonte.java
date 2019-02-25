/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;


public class RouesMonte extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax moteurMonte = new CANSparkMax(6, MotorType.kBrushed); //nouveau moteur, pas une erreure
  @Override
  public void initDefaultCommand() {
  
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  
  }

  
  public void mountedDrive(Joystick m_stick){
    double ystick = m_stick.getRawAxis(2) * 1 - m_stick.getRawAxis(3) * 1;
    moteurMonte.set(-ystick);
   
  }
  public void Brake(){
    moteurMonte.setIdleMode(IdleMode.kBrake);
  }

  public void Coast(){
    moteurMonte.setIdleMode(IdleMode.kCoast);
  }
}
