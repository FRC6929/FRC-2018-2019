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



public class ControllerValveSecurite extends Command {

  double Pitch = 0;
  double offSet = 0;
  int etape = 0;

  public ControllerValveSecurite() {
    requires(Robot.ValveSecurite);
    requires(Robot.GyroSub);
 
  }

  @Override
  protected void initialize() {
   offSet = Robot.GyroSub.GetPitch();
  }

  @Override
  protected void execute() {
    Pitch = Robot.GyroSub.GetPitch();
    double vrai = Pitch - offSet;

    SmartDashboard.putNumber("OffSet", offSet);
    SmartDashboard.putNumber("Correctif", vrai);

    if(vrai < -0.8 && etape == 0){
    
      Robot.ValveSecurite.fermerArriere();
      etape = 2;
    }
    else if(vrai > 0.8 && etape == 0){
     
      Robot.ValveSecurite.fermerAvant();
      etape = 1;
    } else if(vrai < 0.1 && etape == 1){
      Robot.ValveSecurite.OuvrirAvnt();
      Robot.ValveSecurite.OuvrirArriere();
      etape = 0;
    }else if (vrai > -0.1 && etape == 2){
      Robot.ValveSecurite.OuvrirAvnt();
      Robot.ValveSecurite.OuvrirArriere();
      etape = 0;
    } else if(etape == 0){
      Robot.ValveSecurite.OuvrirAvnt();
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
