// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveIntake;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private static DigitalInput topLimitSwitch;
  private static Intake intake;
  private static Button intakeButton;
  private static Joystick joy;
  //private static 
  
  



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    joy = new Joystick(0);
    intake = new Intake(Constants.INTAKE_MOTOR_ID);
    intakeButton = new JoystickButton(joy,2);
  
    
    topLimitSwitch = new DigitalInput(0);
    
    
    // Configure the button bindings
    configureButtonBindings();
  }

  private Button JoystickButton(Joystick joy2, int i) {
    return null;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    intakeButton.whileHeld(new MoveIntake());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public static Intake getIntake(){
    return intake;
  }
  public static Joystick getJoystick(){
    return joy;
  }
  public static boolean getLimitSwitch(){
    return topLimitSwitch.get();
    
  }
}
