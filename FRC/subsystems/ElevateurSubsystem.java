/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateurSubsystem extends PIDSubsystem {
double encTrue;
  CANSparkMax MT1 = new CANSparkMax(4, MotorType.kBrushless);
  CANEncoder Encoder = new CANEncoder(MT1);
  DigitalInput limitswitchSol1;
  DigitalInput limitSwitchSol2;
  double encOfset = Encoder.getPosition();

  public ElevateurSubsystem() {
   
    super("ElevateurSubsystem", 0.15, 0, 0.1);
    limitSwitchSol2 = new DigitalInput(0);
    limitswitchSol1 = new DigitalInput(1);

  }

  @Override
  public void initDefaultCommand() {
  }

  @Override
  protected double returnPIDInput() {

    double Enc = Encoder.getPosition() - encOfset; 
    
    return Enc;
  }

  @Override
  protected void usePIDOutput(double output) {
  MT1.set(output * 0.75);
  }

  public boolean getLimitSol(){
    boolean decision = false;
    boolean limit1Get = limitswitchSol1.get();
    boolean limit2Get = limitSwitchSol2.get();
    if(limit1Get || limit2Get){
      decision = true;
    }
    return decision;
  }

  public void Manuel(double vitesse){
      MT1.set(vitesse);
      double enc = Encoder.getPosition() - encOfset;
      SmartDashboard.putNumber("encSparkMaxime", enc);
      
  }
public void resetEnc(){
  encOfset = Encoder.getPosition();
}




}
