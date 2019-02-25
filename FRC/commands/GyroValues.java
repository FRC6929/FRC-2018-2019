/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GyroValues extends Command {
  public GyroValues() {
    requires(Robot.GyroSub);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double Yaw = Robot.GyroSub.GetYaw();
    double Angle = Robot.GyroSub.GetAngle();
    double Pitch = Robot.GyroSub.GetPitch();
    double Roll = Robot.GyroSub.GetRoll();

    SmartDashboard.putNumber("Yaw", Yaw);
    SmartDashboard.putNumber("Pitch", Pitch);
    SmartDashboard.putNumber("Roll", Roll);
    SmartDashboard.putNumber("Angle", Angle);
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
