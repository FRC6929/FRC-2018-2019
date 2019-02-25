/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class PiloterBasePilotable extends Command {
  Joystick m_stick = new Joystick(0);
  boolean toggleVitesse = false;
  float vitesse = 0f;
  public PiloterBasePilotable() {
    requires(Robot.BasePilotableSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(m_stick.getRawButtonPressed(1)){
      toggleVitesse = !toggleVitesse; 
      }
     
     
    SmartDashboard.putNumber("vitesse", vitesse);


    double ystick = m_stick.getRawAxis(2) * 1 - m_stick.getRawAxis(3) * 1;
    double xstick = - m_stick.getRawAxis(0) * 1;

    Robot.BasePilotableSubsystem.drive(toggleVitesse,xstick, ystick);
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
