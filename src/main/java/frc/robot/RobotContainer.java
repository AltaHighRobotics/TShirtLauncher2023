// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CannonCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.PulleyDownCommand;
import frc.robot.commands.PulleyUpCommand;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.LauncherSub;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private XboxController m_xboxController = new XboxController(Constants.XBOX);
  // The robot's subsystems and commands are defined here...
  private DriveTrainSub m_driveTrainSub = new DriveTrainSub();
  private LauncherSub m_launcherSub = new LauncherSub();

  private DriveCommand m_driveCommand = new DriveCommand(m_driveTrainSub, m_xboxController);
  private PulleyUpCommand m_pulleyUpCommand = new PulleyUpCommand(m_launcherSub);
  private PulleyDownCommand m_pulleyDownCommand = new PulleyDownCommand(m_launcherSub);
  private CannonCommand m_cannonCommand = new CannonCommand(m_launcherSub);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_driveTrainSub, m_driveCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    final JoystickButton pulleyUpButton;
    final JoystickButton pulleyDownButton;
    final JoystickButton cannonButton;
    final JoystickButton cannonButton2;

    pulleyUpButton = new JoystickButton(m_xboxController, Constants.Y_BUTTON);
    pulleyDownButton = new JoystickButton(m_xboxController, Constants.A_BUTTON);
    cannonButton = new JoystickButton(m_xboxController, Constants.LEFT_BUMPER);
    cannonButton2 = new JoystickButton(m_xboxController, Constants.RIGHT_BUMPER);

    pulleyUpButton.whileHeld(m_pulleyUpCommand);
    pulleyDownButton.whileHeld(m_pulleyDownCommand);

    cannonButton.whileHeld(m_cannonCommand);
    cannonButton2.whileHeld(m_cannonCommand);
  }

  /**
   * 
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
