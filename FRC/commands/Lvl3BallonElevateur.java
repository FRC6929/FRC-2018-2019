/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Lvl3BallonElevateur extends Command {
  public Lvl3BallonElevateur() {
  requires(Robot.elevateurSubsystem);  
  }

  @Override
  protected void initialize() {
  Robot.elevateurSubsystem.enable();
  Robot.elevateurSubsystem.setSetpoint(138);
  Robot.elevateurSubsystem.setAbsoluteTolerance(0.01);
  setTimeout(4);
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    boolean finished = Robot.elevateurSubsystem.onTarget();
    boolean TimeOut = isTimedOut();
    boolean Final = false;

    if(finished == true || TimeOut == true){
      Final = true;
    }
    return Final;
  }

  @Override
  protected void end() {
  Robot.elevateurSubsystem.disable();
  }

  @Override
  protected void interrupted() {
    Robot.elevateurSubsystem.disable();
  }
}
