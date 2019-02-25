/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LifterManuelAvant extends Command {
  public LifterManuelAvant() {
    requires(Robot.ValveSecurite);
  }

  @Override
  protected void initialize() {
    
    Robot.ValveSecurite.fermerAvant();
  }

  @Override
  protected void execute() {
    Joystick m_stick = new Joystick(2);

    if(m_stick.getRawButton(9)){
      Robot.ValveSecurite.fermerAvant();
    }else{
      Robot.ValveSecurite.OuvrirAvnt();
    }

    if(m_stick.getRawButton(6)){
      Robot.ValveSecurite.fermerArriere();
    }else{
      Robot.ValveSecurite.OuvrirArriere();
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
