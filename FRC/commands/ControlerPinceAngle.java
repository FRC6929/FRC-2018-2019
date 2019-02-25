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

public class ControlerPinceAngle extends Command {
  Joystick coPilote_stick1 = new Joystick(2);
  public ControlerPinceAngle() {
    requires(Robot.pinceAngle);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double valeur =  coPilote_stick1.getRawAxis(0);
      Robot.pinceAngle.controllerPince(valeur);
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
