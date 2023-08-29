// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSub extends SubsystemBase 
{
  /** Creates a new DriveTrainSub.4 */
  private WPI_VictorSPX leftDrive1;
  private WPI_VictorSPX leftDrive2;
  private WPI_VictorSPX rightDrive1;
  private WPI_VictorSPX rightDrive2;
  
  public DriveTrainSub() 
  {
    leftDrive1 = new WPI_VictorSPX(Constants.LEFT_DRIVE_1);
    leftDrive2 = new WPI_VictorSPX(Constants.LEFT_DRIVE_2);

    rightDrive1 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_1);
    rightDrive2 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_2);

    rightDrive1.setInverted(true);
    rightDrive2.setInverted(true);
  }

  public void setRightMotors(double speed)
  {
    rightDrive1.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
    //rightDrive2.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
  }

  public void setLeftMotors(double speed)
  {
    //leftDrive1.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
    leftDrive2.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
  }

  public void setArcadeDrive(double forwardPower, double turnPower) {
    setRightMotors(-forwardPower - turnPower);
    setLeftMotors(-forwardPower + turnPower);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
