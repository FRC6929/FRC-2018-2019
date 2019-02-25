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

public class Lifter extends Subsystem {

  DoubleSolenoid rouesAvant = new DoubleSolenoid(0, 4, 5);
  DoubleSolenoid rouesArriere = new DoubleSolenoid(0, 0, 1);
 

  @Override
  public void initDefaultCommand() {

  }

  public void monterRoues(){
    rouesAvant.set(Value.kForward);
    rouesArriere.set(Value.kForward);
 
  }
  
  public void descendreRouesAvant(){
    rouesAvant.set(Value.kReverse);

  }
  public void descendreArriere(){
    rouesArriere.set(Value.kReverse);
 
  }

  public void descendreBoth(){
    rouesArriere.set(Value.kReverse);
    rouesAvant.set(Value.kReverse);
  }

  public void arreterAvant(){
    rouesAvant.set(Value.kOff);
  }

  public void arreterArriere(){
    rouesArriere.set(Value.kOff);
  }

  public void arreterBoth(){
    rouesArriere.set(Value.kOff);
    rouesAvant.set(Value.kOff);
  }
}
