/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;


//  Add your docs here.
 
public class PinceAngle extends PIDSubsystem {
 
  TalonSRX moteur = new TalonSRX(0);
  Potentiometer pot;
 
  final int kTimeoutMs = 30;

  

  public PinceAngle() {
    
    // Intert a subsystem name and PID values here
    super("PinceAnglePid", 0.05, 0, 0.01);
   
    pot = new AnalogPotentiometer(3, 270, 0);
    
    moteur.configFactoryDefault();
    moteur.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,	// Feedback
    0, 											// PID ID
    kTimeoutMs);								// Timeout
    
    
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new ControlerPinceAngle());
  }

  public void controllerPince(double valeur){
    
    moteur.set(ControlMode.PercentOutput, valeur * 0.45);
    double potValue = pot.get();
    SmartDashboard.putNumber("Potentiometre", potValue);
    
   }
  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    double potValue = pot.get();

    return potValue;
  }

  @Override
  protected void usePIDOutput(double output) {

    moteur.set(ControlMode.PercentOutput, output * -0.7);
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }

}
