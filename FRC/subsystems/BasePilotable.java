/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.Map;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class BasePilotable extends Subsystem {
  NetworkTableEntry xCenterEntry;
  NetworkTableEntry heightEntry;

CANSparkMax moteurDrive0 = new CANSparkMax(0, MotorType.kBrushless);
CANSparkMax moteurDrive1 = new CANSparkMax(1, MotorType.kBrushless);
CANSparkMax moteurDrive2 = new CANSparkMax(2, MotorType.kBrushless);
CANSparkMax moteurDrive3 = new CANSparkMax(3, MotorType.kBrushless);
CANEncoder encoder0 = new CANEncoder(moteurDrive0);
CANEncoder encoder1 = new CANEncoder(moteurDrive1);
CANEncoder encoder2 = new CANEncoder(moteurDrive2);
CANEncoder encoder3 = new CANEncoder(moteurDrive3);


private DifferentialDrive m_robotDrive1 = new DifferentialDrive(moteurDrive0,moteurDrive2);

private ShuffleboardTab tab = Shuffleboard.getTab("DifferentialDrive");

private NetworkTableEntry vitesseShuffleBoard1 = tab.add("Vitesse1", 0.25)
  .withWidget(BuiltInWidgets.kNumberSlider)
  .withProperties(Map.of("min", 0, "max", 1))
  .getEntry();

private NetworkTableEntry vitesseShuffleBoard2 = tab.add("Vitesse2", 0.75)
  .withWidget(BuiltInWidgets.kNumberSlider)
  .withProperties(Map.of("min", 0, "max", 1))
  .getEntry();



  public BasePilotable(){

    
   NetworkTableInstance inst = NetworkTableInstance.getDefault();
	NetworkTable table = inst.getTable("GRIP/Contours");
   xCenterEntry = table.getEntry("centerX");
   heightEntry = table.getEntry("height");
  }

  public void drive(boolean toggleVitesse, double xstick, double ystick){
double vitesse = 0;
    if(toggleVitesse == false){
      vitesse = vitesseShuffleBoard1.getDouble(0);
    }else{
      vitesse = vitesseShuffleBoard2.getDouble(1);
    }

SmartDashboard.putNumber("Encoder0", encoder0.getPosition());
SmartDashboard.putNumber("Encoder1", encoder1.getPosition());
SmartDashboard.putNumber("Encoder2", encoder2.getPosition());
SmartDashboard.putNumber("Encoder3", encoder3.getPosition());

    m_robotDrive1.arcadeDrive(-ystick * vitesse, -xstick * vitesse);
 
  }

  @Override
  public void initDefaultCommand() {
 
 }


      public void autoDrive(double x, double y){
        m_robotDrive1.arcadeDrive(x, -y);

      }

    public double GetVisionCenterX(){
  
      double[] gripValues = new double[0];
      double[] XArray =  xCenterEntry.getDoubleArray(gripValues);
      
      double XCenter = 0;
  
  if(XArray.length > 1){
    double XValue1 = XArray[0];
    double XValue2 = XArray[1];
  
     XCenter = (XValue1 + XValue2) / 2;
  }
  SmartDashboard.putNumber("CentreVision", XCenter);
      return XCenter;
    }
  
    public double[] GetVisionHeight(){
      double[] gripValues = new double[0];
      double[] heightArray = heightEntry.getDoubleArray(gripValues);
  
      return heightArray;
    }


}
