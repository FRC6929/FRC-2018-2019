/*----------------------------------------------------------------------------*/
/* Cpyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class PinceAHatch extends Subsystem {
  DoubleSolenoid hatcherPneu = new DoubleSolenoid(0, 2, 3);

  @Override
  public void initDefaultCommand() {
  }

  public void Prendre() {
  hatcherPneu.set(Value.kReverse);

  }

  public void Deposer() {
  hatcherPneu.set(Value.kForward);
  
  }


}
  

