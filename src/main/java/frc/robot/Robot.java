// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.spark.SparkMax;
import com.studica.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The methods in this class are called automatically corresponding to each
 * mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the
 * package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  
    VictorSPX Lmotor1 = new VictorSPX(34);
    TalonSRX Lmotor2 = new TalonSRX(33);
    VictorSPX Rmotor1 = new VictorSPX(31);
    TalonSRX Rmotor2 = new TalonSRX(32);
   
  Joystick joystick = new Joystick(0);
   AHRS gyro = new AHRS(AHRS.NavXComType.kMXP_SPI);

  Compressor com = new Compressor(PneumaticsModuleType.CTREPCM);
  DoubleSolenoid sol = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  public Robot() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {

    
      if (joystick.getRawButton(2)) {
      gyro.reset();
      }
      double angle = gyro.getYaw();
      double ENC = Lmotor2.getSelectedSensorPosition();
      
      Lmotor1.set(ControlMode.PercentOutput, joystick.getRawAxis(1) * -0.5);
      Lmotor2.set(ControlMode.PercentOutput, joystick.getRawAxis(1) * -0.5);
      Rmotor1.set(ControlMode.PercentOutput, joystick.getRawAxis(5) * 0.5);
      Rmotor2.set(ControlMode.PercentOutput, joystick.getRawAxis(5) * 0.5);
      
      SmartDashboard.putNumber("angle", angle);
      SmartDashboard.putNumber("Encoder", ENC);
     
    if (joystick.getRawButton(1)) {
      com.enableDigital();
    } else if (joystick.getRawButton(2)) {
      com.disable();
    } else if (joystick.getRawButton(3)) {
      sol.set(Value.kForward);
    } else if (joystick.getRawButton(4)) {
      sol.set(Value.kReverse);
    }
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
