// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.util.Timer;
import java.util.TimerTask;

public class LauncherSub extends SubsystemBase {
  /** Creates a new LauncherSub. */
  private WPI_TalonSRX pulleyMotor;
  private Solenoid launchSolenoid;
  private Timer timer;
  private TimerTask timerTask;
  public LauncherSub() 
  {
    pulleyMotor = new WPI_TalonSRX(Constants.PULLEY_MOTOR);
    launchSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.LAUNCH_SOLENOID);

    timer = new Timer();

    timerTask = new TimerTask(){
      @Override
        public void run() {
          launchSolenoid.set(false);
        }
    };
  }

  public void pulleyUp()
  {
    pulleyMotor.set(Constants.PULLEY_UP_SPEED);
  }

  public void pulleyDown()
  {
    pulleyMotor.set(-Constants.PULLEY_DOWN_SPEED);
  }

  public void pulleyOff()
  {
    pulleyMotor.set(0.0);
  }

  /*
  public void launcher()
  {
    launchSolenoid.set(true);
    timer.schedule(timerTask, 50);
  }
  */

  public void launcherOff()
  {
    launchSolenoid.set(false);
  }

  public void launcherOn()
  {
    launchSolenoid.set(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
