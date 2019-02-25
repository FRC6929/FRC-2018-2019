/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*---------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class VisionProcessing extends Command {

  double calcul;
  boolean premiereMesure;

  public VisionProcessing() {

    requires(Robot.BasePilotableSubsystem);
    requires(Robot.GyroSub);
 
  }

  @Override
  protected void initialize() {
    premiereMesure = false;
   Robot.GyroSub.resetAhrs();
   
  }

  @Override
  protected void execute() {
    double XCenter = Robot.BasePilotableSubsystem.GetVisionCenterX();
    double angleVise = 160 * 7 / 147;
    SmartDashboard.putNumber("XCenter", XCenter);
    if(XCenter != 0) {

      if(premiereMesure == false) {
      
        double trouve =  XCenter * 7 / 147;//10.33 //7/147
        
        premiereMesure = true;  
        
        calcul = trouve - angleVise;
      }
      
      if(premiereMesure == true) {
        
        double angleGyro = Robot.GyroSub.GetAngle();
        double setPoint = -calcul + angleGyro ;
        double setPointTrue = setPoint;

        SmartDashboard.putNumber("setPoint", setPoint);
        SmartDashboard.putNumber("SetPointTrue", setPointTrue);
        SmartDashboard.putNumber("GPS", angleGyro);
        SmartDashboard.putNumber("calcul", calcul);
        if(setPointTrue > 0.5) {
          setPointTrue = 0.5;
        }
        if (setPointTrue < -0.5) {
          setPointTrue = -0.5;
        }
       Robot.BasePilotableSubsystem.autoDrive(0.5, setPointTrue);
        
      }
                                                                                 
  }else if (premiereMesure == true) {
    double angleGyro = Robot.GyroSub.GetAngle();

    double setPoint =  -calcul + angleGyro ;
   
    double setPointTrue = setPoint;

    SmartDashboard.putNumber("setPoint", setPoint);
    SmartDashboard.putNumber("SetPointTrue", setPointTrue);
    SmartDashboard.putNumber("GPS", angleGyro);
    if(setPointTrue > 0.5) {
      setPointTrue = 0.5;
    }
    if (setPointTrue < -0.5) {
      setPointTrue = -0.5;
    }
 Robot.BasePilotableSubsystem.autoDrive(0.5, setPointTrue);
 

  }else {
 Robot.BasePilotableSubsystem.autoDrive(0, 0.5);
  
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
