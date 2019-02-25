/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AngleBallonLvl3 extends Command {
  public double m_timeout;
  public AngleBallonLvl3() {
    requires(Robot.pinceAngle);
  }

  @Override
  protected void initialize() {
    Robot.pinceAngle.enable();
    Robot.pinceAngle.setSetpoint(170);
    Robot.pinceAngle.setAbsoluteTolerance(1);
    setTimeout(2);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    boolean choice = Robot.pinceAngle.onTarget();
    boolean TimeOut = isTimedOut();
    boolean Final = false;

    if(choice == true || TimeOut == true){
      Final = true;
    }
    return Final;
  }

  @Override
  protected void end() {
    Robot.pinceAngle.disable();
  }

  @Override
  protected void interrupted() {
    Robot.pinceAngle.disable();

  }
}
