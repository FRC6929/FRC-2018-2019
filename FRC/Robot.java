//----------------------------------------------------------------
//-----------------------FRC 2019---------------------------------
//---------------------Cuivre et or-------------------------------
//------------------Command based robot---------------------------
//---Code d'edi utilise durant la competition week 1 a montreal---
//--Ce code peut-etre utilise par tous afin de s'en inspirer et---
//------------------d'apprendre a coder---------------------------
//----------------------------------------------------------------

package frc.robot;



import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.DescendreRouesAvant;
import frc.robot.commands.ElevateurManuel;
import frc.robot.commands.Lvl1BallonElevateur;
import frc.robot.commands.Lvl2BallonElevateur;
import frc.robot.commands.Lvl3BallonElevateur;
import frc.robot.commands.LvlSolBallonElevateur;
import frc.robot.commands.LvlDistributeurBallonElevateur;
import frc.robot.commands.LvlCargoBallonElevateur;
import frc.robot.commands.Lvl1HatchElevateur;
import frc.robot.commands.Lvl2HatchElevateur;
import frc.robot.commands.Lvl3HatchElevateur;
import frc.robot.commands.MonterRoues;
import frc.robot.commands.PiloterBasePilotable;
import frc.robot.commands.PrendreBallon;
import frc.robot.commands.PrendreHatch;
import frc.robot.commands.VisionProcessing;
import frc.robot.commands.ControlerPinceAngle;
import frc.robot.commands.ControllerValveSecurite;
import frc.robot.commands.DeposerHatch;
import frc.robot.commands.DescendreBoth;
import frc.robot.commands.DescendreRouesArriere;
import frc.robot.commands.RoulerMonte;
import frc.robot.commands.ResetElevateur;
import frc.robot.commands.LifterLvl2;
import frc.robot.commands.ResetValveSecurite;
import frc.robot.commands.AngleBallonLvl3;
import frc.robot.commands.AngleDefault;
import frc.robot.commands.AngleDepart;
import frc.robot.commands.AngleHatchLvl1;
import frc.robot.commands.AngleLvlSol;
import frc.robot.commands.LifterManuelAvant;
import frc.robot.commands.ArreterPinceBallon;
import frc.robot.commands.DeposerBallon;

import frc.robot.subsystems.RouesMonte;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.ElevateurSubsystem;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Lifter;
import frc.robot.subsystems.PinceAHatch;
import frc.robot.subsystems.PinceAngle;
import frc.robot.subsystems.ValveSecurite;
import frc.robot.subsystems.PinceBallon;


public class Robot extends TimedRobot {

 public static BasePilotable BasePilotableSubsystem = new BasePilotable();
  public static ElevateurSubsystem elevateurSubsystem = new ElevateurSubsystem();
  public static PinceAHatch hatcherSubsystem = new PinceAHatch();
  public static Lifter lifterSubsystem = new Lifter();
  public static RouesMonte RouesMonte = new RouesMonte();
  public static PinceBallon PinceBallon = new PinceBallon();
  //public static PinceAngle1 pinceAngle1 = new PinceAngle1();
  public static PinceAngle pinceAngle = new PinceAngle();
  public static ValveSecurite ValveSecurite = new ValveSecurite();
  public static Gyro GyroSub = new Gyro();

  public static OI m_oi;

  Command OuvrirValveSecuriteArriere;
  Command OuvrirValveSecuriteAvant;
  Command PrendreHatch;
  Command DeposerHatch;
  Command MonterRoues;
  Command DescendreRouesAvant;
  Command DescendreRouesArriere;
  Command Roulermonte;
//  Command DescendrePinceAngle;
//  Command MonterPinceAngle;
Command ControlerValveSecurite;
  Command DeposerBallon; 
  Command ArreterLifterArriere;
  Command PrendreBallon;
  Command ArreterPinceBallon;
  Command DescendreBoth;
  Command ManuelElevateur;
  Command controllerPinceAngle;
  Command Lvl1BallonElevateur;
  Command Lvl2BallonElevateur;
  Command Lvl3BallonElevateur;
  Command LvlSolBallonElevateur;
  Command LvlCargoBallonElevateur;
  Command LvlDistributeurBallonElevateur;
  Command Lvl1HatchElevateur;
  Command Lvl2HatchElevateur;
  Command Lvl3HatchElevateur;
  Command AngleBallonLvl3;
  Command AngleDefault;
  Command AngleDepart;
  Command AngleHatchLvl1;
  Command LifterManuelAvant;
  Command AngleLvlSol;
  Command ControllerPinceAngle;
  Command ResetElevateur;
  Command VisionProcessing;
  Command LifterLvl2;
Command PiloterBasePilotable;
  Command ResetValveSecurite;

Joystick m_stick = new Joystick(0);
  Joystick coPilote_stickRouge = new Joystick(1);
  Joystick coPilote_stickBleu = new Joystick(2);
  int etapeFin = 0;
  boolean retracted = false;
  int lvlSpecial = 0;
  int lvlEtape = 0;


  @Override
  public void robotInit() {
    

    m_oi = new OI();
    LifterManuelAvant = new LifterManuelAvant();
    LifterLvl2 = new LifterLvl2();
    ControlerValveSecurite = new ControllerValveSecurite();
    ControllerPinceAngle = new ControlerPinceAngle();
  Lvl1BallonElevateur = new Lvl1BallonElevateur();
  Lvl2BallonElevateur = new Lvl2BallonElevateur();
  Lvl3BallonElevateur = new Lvl3BallonElevateur();
  LvlSolBallonElevateur = new LvlSolBallonElevateur();
  LvlDistributeurBallonElevateur = new LvlDistributeurBallonElevateur();
  LvlCargoBallonElevateur = new LvlCargoBallonElevateur();
  Lvl1HatchElevateur = new Lvl1HatchElevateur();
  Lvl2HatchElevateur = new Lvl2HatchElevateur();
  Lvl3HatchElevateur = new Lvl3HatchElevateur();
  VisionProcessing = new VisionProcessing();
 ManuelElevateur = new ElevateurManuel();
 PiloterBasePilotable = new PiloterBasePilotable();
 DescendreBoth = new DescendreBoth();
  PrendreHatch = new PrendreHatch();
 DeposerHatch = new DeposerHatch();
  MonterRoues = new MonterRoues();
  ArreterPinceBallon = new ArreterPinceBallon();
  DescendreRouesAvant = new DescendreRouesAvant();
 DescendreRouesArriere = new DescendreRouesArriere();
  Roulermonte = new RoulerMonte();
  ResetElevateur = new ResetElevateur();
 // DescendrePinceAngle = new DescendrePinceAngle();
 // MonterPinceAngle = new MonterPinceAngle();
  DeposerBallon = new DeposerBallon(); 
  PrendreBallon = new PrendreBallon();
  controllerPinceAngle = new ControlerPinceAngle();
   AngleBallonLvl3 = new AngleBallonLvl3();
   AngleDefault    = new  AngleDefault();
   AngleDepart     = new AngleDepart();
   AngleHatchLvl1  = new AngleHatchLvl1();
   AngleLvlSol     = new AngleLvlSol();
    ResetValveSecurite = new ResetValveSecurite();


UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
  camera1.setResolution(320, 180);
    camera1.setFPS(30);
 camera1.setExposureManual(30);
 
 camera2.setResolution(320, 180);
 camera2.setFPS(30);
camera2.setExposureManual(40);



  }

  
  @Override
  public void robotPeriodic() {
    
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

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
   etapeFin = 0;
   lvlEtape = 0;
   lvlSpecial = 0;
    retracted = false;
   
    ResetValveSecurite.start();
   elevateurSubsystem.disable();
   pinceAngle.disable();
   ManuelElevateur.start();
   controllerPinceAngle.start();
    ResetElevateur.start();



  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
   Scheduler.getInstance().run();
    

   if(etapeFin == 0 && retracted == false){
  DescendreBoth.start();
  PiloterBasePilotable.start();
    retracted = true;
   }


    if (coPilote_stickBleu.getRawButtonPressed(4)){
      PrendreHatch.start();
    }

    if (coPilote_stickBleu.getRawButtonPressed(5)){
      DeposerHatch.start();
    }
  //---------Lifter Lvl 3, toutes les etapes----------
    if (coPilote_stickBleu.getRawButton(9) && coPilote_stickBleu.getRawButton(6) && etapeFin == 0){
      Roulermonte.start();
      MonterRoues.start();
      if(ControlerValveSecurite.isRunning() == false){
        ControlerValveSecurite.start();
      }

   //   if(LifterManuelAvant.isRunning() == false){
    //    LifterManuelAvant.start();
    //  }
    
      etapeFin = 1;
    }else if (coPilote_stickBleu.getRawButton(7) && 
               etapeFin == 1 
              ) {
      DescendreRouesAvant.start();
      Roulermonte.cancel();
      ControlerValveSecurite.cancel();
      ResetValveSecurite.start();
    }
    else if (coPilote_stickBleu.getRawButton(8) && etapeFin == 1
              ) {
      DescendreRouesArriere.start();
      etapeFin = 0;
 
    }else if(coPilote_stickBleu.getRawButton(7) && coPilote_stickBleu.getRawButton(8)){
      DescendreBoth.start();
      
      etapeFin = 0;
    }


    //----------Lifter Lvl 2--------------------
if(m_stick.getRawButton(5) && m_stick.getRawButton(6)){
  LifterLvl2.start();
  etapeFin = 1;
}

    if (coPilote_stickRouge.getRawButton(7)) {
      DeposerBallon.start();
    }

    if (coPilote_stickRouge.getRawButton(8)) {
      PrendreBallon.start();
   }

   if(coPilote_stickRouge.getRawButton(7) == false && coPilote_stickRouge.getRawButton(8) == false){
      ArreterPinceBallon.start();
   }

//-----Elevateur rouge/ballon lvl 1-----------------------

   if(lvlEtape == 1){
          
    if(Lvl1BallonElevateur.isRunning() == false){
      AngleDefault.start();
      lvlEtape = 0;
    }
  }else if (coPilote_stickRouge.getRawButtonPressed(4)) {
    lvlEtape = 1;
     Lvl1BallonElevateur.start();
     AngleDefault.start();
}

//-----Elevateur rouge/ballon lvl 2----------------------

if(lvlEtape == 2){
      
  if(Lvl2BallonElevateur.isRunning() == false){
    AngleDefault.start();
    lvlEtape = 0;
  }
}
   if (coPilote_stickRouge.getRawButtonPressed(5)) {
     Lvl2BallonElevateur.start();
     AngleDefault.start();
     lvlEtape = 2;
   }

//-----Elevateur rouge/ballon lvl 3----------------------
      
  if(lvlEtape == 3){
      
    if(Lvl3BallonElevateur.isRunning() == false){
      AngleBallonLvl3.start();
      lvlEtape = 0;
    }
  }else if (coPilote_stickRouge.getRawButtonPressed(6)) {
    Lvl3BallonElevateur.start();
    AngleDefault.start();
    lvlEtape = 3;
  }

//-----Elevateur rouge/ballon lvl Sol----------------------

if(lvlEtape == 4){
  if(LvlSolBallonElevateur.isRunning() == false){
    AngleLvlSol.start();
    
    lvlEtape = 0;
  }
}
   if (coPilote_stickRouge.getRawButtonPressed(1)) {
     LvlSolBallonElevateur.start();
     AngleDefault.start();
     lvlEtape = 4;
   }
//-----Elevateur rouge/ballon lvl Cargo----------------------
   if(lvlEtape == 5){
    if(LvlCargoBallonElevateur.isRunning() == false){
      AngleDefault.start();
      lvlEtape = 0;
    }

   }
   if (coPilote_stickRouge.getRawButtonPressed(2)) {
     LvlCargoBallonElevateur.start();
     AngleDefault.start();
     lvlEtape = 5;
   }
//-----Elevateur rouge/ballon lvl Distributeur----------------

   if(lvlEtape == 6){
  if(LvlDistributeurBallonElevateur.isRunning() == false){
      AngleDefault.start();
      lvlEtape = 0;
   }  
  }
   if (coPilote_stickRouge.getRawButtonPressed(3)) {
     LvlDistributeurBallonElevateur.start();
     AngleDefault.start();
     lvlEtape = 6;
   }

//-----Elevateur bleu/hatch lvl 1----------------------
   if(lvlEtape == 7){
    if(Lvl1HatchElevateur.isRunning() == false){
      AngleHatchLvl1.start();
      AngleDefault.start();
      lvlEtape = 0;
   }
   }

   if (coPilote_stickBleu.getRawButtonPressed(1)) {
     Lvl1HatchElevateur.start(); 
     AngleDefault.start();
     
     lvlEtape = 7;
   }

//-----Elevateur bleu/hatch lvl 2----------------------
if(lvlEtape == 8){
  if(Lvl2HatchElevateur.isRunning() == false){
    AngleDefault.start();
    lvlEtape = 0;
 }
}
   if (coPilote_stickBleu.getRawButtonPressed(2)) {
     Lvl2HatchElevateur.start();
     AngleDefault.start();
     lvlEtape = 8;
   }

//-----Elevateur bleu/hatch lvl 3----------------------
if(lvlEtape == 9){
  if(Lvl3HatchElevateur.isRunning() == false){
    AngleDefault.start();
    lvlEtape = 0;
 }
}
   if (coPilote_stickBleu.getRawButtonPressed(3)) {
     Lvl3HatchElevateur.start();
     AngleDefault.start();
     lvlEtape = 9;
   }

//---------Vision, pilote stick button 2 et 4----------  
if(m_stick.getRawButtonPressed(4)){
  VisionProcessing.start();
}

if(m_stick.getRawButtonPressed(2)){
  VisionProcessing.cancel();
  PiloterBasePilotable.start();
}

//-------Modes manuels, annuler auto----------------
if(coPilote_stickBleu.getRawAxis(1) < -0.1 || coPilote_stickBleu.getRawAxis(1) > 0.1){
 if(ManuelElevateur.isRunning() == false){
  ManuelElevateur.start();
 }
 
}
if(coPilote_stickBleu.getRawAxis(0) < -0.1 || coPilote_stickBleu.getRawAxis(0) > 0.1){
  if(ControllerPinceAngle.isRunning() == false){
    ControllerPinceAngle.start();
  }

}





  }


  @Override
  public void testPeriodic() {
  }

}

