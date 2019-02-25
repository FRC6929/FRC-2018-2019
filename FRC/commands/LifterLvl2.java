/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LifterLvl2 extends Command {
  public LifterLvl2() {
    requires(Robot.ValveSecurite);
    requires(Robot.lifterSubsystem);
  }

  @Override
  protected void initialize() {
    setTimeout(2);
    Robot.lifterSubsystem.monterRoues();
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
   boolean timeout = isTimedOut();
    return timeout;
  }

  @Override
  protected void end() {
    Robot.ValveSecurite.fermerArriere();
    Robot.ValveSecurite.fermerAvant();
  }

  @Override
  protected void interrupted() {
  }
}
