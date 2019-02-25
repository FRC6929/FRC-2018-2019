/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ValveSecurite extends Subsystem {
  
  double offset = 0;
  
DoubleSolenoid valveSecuriteAvant = new DoubleSolenoid(1, 2, 3);
DoubleSolenoid valveSecuriteArriere = new DoubleSolenoid(1, 0, 1);
  @Override
  public void initDefaultCommand() {
  }
public ValveSecurite(){

  
}
public void OuvrirAvnt(){
      valveSecuriteAvant.set(Value.kForward);
    
  }

  public void OuvrirArriere(){
    valveSecuriteArriere.set(Value.kForward);
  }
  public void fermerAvant(){
    valveSecuriteAvant.set(Value.kReverse);
  }
  public void fermerArriere(){
    valveSecuriteArriere.set(Value.kReverse);
  }


}