/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import java.util.Map;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ControllerMoteur;

/**
 * Add your docs here.
 */

public class Moteur extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  AHRS ahrs;
CANSparkMax moteurDrive0 = new CANSparkMax(0, MotorType.kBrushless);
CANSparkMax moteurDrive1 = new CANSparkMax(1, MotorType.kBrushless);
CANSparkMax moteurDrive2 = new CANSparkMax(2, MotorType.kBrushless);
CANSparkMax moteurDrive3 = new CANSparkMax(3, MotorType.kBrushless);
CANEncoder encoder0 = new CANEncoder(moteurDrive0);
CANEncoder encoder1 = new CANEncoder(moteurDrive1);
CANEncoder encoder2 = new CANEncoder(moteurDrive2);
CANEncoder encoder3 = new CANEncoder(moteurDrive3);

SpeedControllerGroup m_leftController; 
SpeedControllerGroup m_rightController;

private DifferentialDrive m_robotDrive1;

private ShuffleboardTab tab = Shuffleboard.getTab("DifferentialDrive");
private NetworkTableEntry vitesseShuffleBoard1 = tab.add("Vitesse1", 0.25)
.withWidget(BuiltInWidgets.kNumberSlider)
.withProperties(Map.of("min", 0, "max", 1))
.getEntry();

private NetworkTableEntry vitesseShuffleBoard2 = tab.add("Vitesse2", 0.75)
.withWidget(BuiltInWidgets.kNumberSlider)
.withProperties(Map.of("min", 0, "max", 1))
.getEntry();


double vitesse = 0;
boolean toggleVitesse = false;
  public Moteur (){
      ahrs = new AHRS(SPI.Port.kMXP);
   
   
   
   
    m_leftController = new SpeedControllerGroup(moteurDrive0, moteurDrive1);
    m_rightController = new SpeedControllerGroup(moteurDrive2, moteurDrive3);
    m_robotDrive1  = new DifferentialDrive(m_leftController,m_rightController);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ControllerMoteur());
  }

  public void drive(Joystick m_stick){

    SmartDashboard.putNumber("Encoder0", encoder0.getPosition());
    SmartDashboard.putNumber("Encoder1", encoder1.getPosition());
    SmartDashboard.putNumber("Encoder2", encoder2.getPosition());
    SmartDashboard.putNumber("Encoder3", encoder3.getPosition());
   
    double ystick = m_stick.getRawAxis(2) * 1 - m_stick.getRawAxis(3) * 1;
    double xstick = - m_stick.getRawAxis(0) * 1;
   
    if(m_stick.getRawButtonPressed(1)){
      toggleVitesse = false;
    }else if(m_stick.getRawButtonPressed(2)){
      toggleVitesse = true;
    }


    if(toggleVitesse == false){
      vitesse = vitesseShuffleBoard1.getDouble(0);
    }else{
      vitesse = vitesseShuffleBoard2.getDouble(1);
    }
  
    SmartDashboard.putNumber("vitesse", vitesse);

   m_robotDrive1.arcadeDrive(-ystick, xstick);
 
  }
}
