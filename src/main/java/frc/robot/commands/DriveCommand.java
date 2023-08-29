// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSub;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  private DriveTrainSub m_driveTrainSub;
  private XboxController m_xboxController;
  
  private double leftStickY;
  private double leftStickX;

  public DriveCommand(DriveTrainSub subsystem, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrainSub = subsystem;
    m_xboxController = xboxController;
    addRequirements(m_driveTrainSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    leftStickY = m_xboxController.getRawAxis(Constants.LEFT_Y_AXIS);
    leftStickX = m_xboxController.getRawAxis(Constants.LEFT_X_AXIS);

    m_driveTrainSub.setArcadeDrive(leftStickY, leftStickX * Constants.TURN_POWER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
