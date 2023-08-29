// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSub;

public class CannonCommand extends CommandBase {
  /** Creates a new CannonCommand. */
  private LauncherSub m_launcherSub;
  public CannonCommand(LauncherSub subsystem) 
  {
    m_launcherSub = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_launcherSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    m_launcherSub.launcherOn(); 
    System.out.println("CannonCommand running");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_launcherSub.launcherOff();
    System.out.println("CannonCommand stopped");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
