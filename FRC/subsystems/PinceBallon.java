/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class PinceBallon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSPX MPR1 = new VictorSPX(0);
  VictorSPX MPR2 = new VictorSPX(1);
  public PinceBallon(){
   }
@Override
  public void initDefaultCommand() {
  }
  public void Prendre(){
    MPR2.set(ControlMode.PercentOutput, -0.6);
    MPR1.set(ControlMode.PercentOutput, -0.6);
  }
  public void Deposer(){
    MPR1.set(ControlMode.PercentOutput, 0.6);
    MPR2.set(ControlMode.PercentOutput, 0.6);

  }
  public void Arreter(){
    MPR1.set(ControlMode.PercentOutput, 0);
    MPR2.set(ControlMode.PercentOutput, 0);
  }
}
