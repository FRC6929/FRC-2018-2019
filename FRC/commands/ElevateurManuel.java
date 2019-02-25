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

public class ElevateurManuel extends Command {
  Joystick coPiloteStickBleu = new Joystick(2);

  public ElevateurManuel() {
    requires(Robot.elevateurSubsystem);
  }

  @Override
  protected void initialize() {
 
  }

  @Override
  protected void execute() {
   
    double vitesse = coPiloteStickBleu.getRawAxis(1);
    if(-vitesse < 0){
      Robot.elevateurSubsystem.Manuel(-vitesse*0.3);
      
    }else{
      Robot.elevateurSubsystem.Manuel(-vitesse*1);

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
