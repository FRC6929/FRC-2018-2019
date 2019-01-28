/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

//import frc.robot.commands.AvancerMoteur;
import frc.robot.subsystems.Moteur;
import frc.robot.subsystems.PinceAHatch;
import frc.robot.subsystems.PinceAngle;
import frc.robot.subsystems.PinceAngle1;
import frc.robot.subsystems.SystemDesSelenoidsPourMonterALaFin;
import frc.robot.subsystems.RouesMonte;
import frc.robot.subsystems.PinceBallon;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Moteur mouteurSubsystem = new Moteur();
  public static PinceAHatch hatcherSubsystem = new PinceAHatch();
  public static SystemDesSelenoidsPourMonterALaFin lifterSubsystem = new SystemDesSelenoidsPourMonterALaFin();
  public static RouesMonte RouesMonte = new RouesMonte();
  public static PinceBallon PinceBallon = new PinceBallon();
  public static PinceAngle1 pinceAngle1 = new PinceAngle1();
  public static PinceAngle pinceAngle = new PinceAngle();
  public static OI m_oi;
  
  Command PrendreHatch;
  Command DeposerHatch;
  Command MonterRoues;
  Command DescendreRouesAvant;
  Command DescendreRouesArriere;
  Command roulermonte;
  Command DescendrePinceAngle;
  Command MonterPinceAngle;

  CANSparkMax moteur = new CANSparkMax(0, MotorType.kBrushless);
//  Command AvancerMoteur;
  Joystick coPilote_stick = new Joystick(1);
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    
  UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
 //camera.setResolution(640, 360);
 camera.setResolution(480, 270);
 camera.setFPS(15);
  
  camera.setExposureManual(40);
    //AvancerMoteur = new AvancerMoteur();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    
    
    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    if (coPilote_stick.getRawButtonPressed(3)){
    PrendreHatch.start();
    }
    if (coPilote_stick.getRawButtonPressed(4)){
      DeposerHatch.start();
    }
    if (coPilote_stick.getRawButtonPressed(5) && coPilote_stick.getRawButtonPressed(6)){
      MonterRoues.start();
    }
    int etapeFin = 0;
    if (coPilote_stick.getRawButtonPressed(5) && coPilote_stick.getRawButtonPressed(6)){
      roulermonte.start();
      etapeFin = 1;
    }
    if (coPilote_stick.getRawButtonPressed(7) && etapeFin == 1) {
      DescendreRouesAvant.start();
      etapeFin = 2;
    }
    if (coPilote_stick.getRawButtonPressed(8) && etapeFin == 2) {
      DescendreRouesArriere.start();
      etapeFin = 3;
    }
    if (coPilote_stick.getRawButtonPressed(9)) {
      DescendrePinceAngle.start();
    }
  
  
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
