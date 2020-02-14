/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.StorageSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

/**
 * An example command that uses an example subsystem.
 */
public class ShootCommand extends ParallelCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private ShooterSubsystem m_shooterSubsystem;
  //private StorageSubsystem m_storageSubsystem;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootCommand(ShooterSubsystem shooterSubsystem/*, StorageSubsystem storageSubsystem*/) {
    super(
        new PrintCommand("Running"),
        new RunCommand(() -> shooterSubsystem.shoot())
       // new RunCommand(() -> storageSubsystem.reverseFeed(), storageSubsystem)
    );
    
    m_shooterSubsystem = shooterSubsystem;
   // m_storageSubsystem = storageSubsystem;

  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopping");
    m_shooterSubsystem.stop();
    m_shooterSubsystem.resetEncoder();
   // m_storageSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    if (Math.abs(m_shooterSubsystem.getEncoder()) > 2048*100) {
      return true;
    } 
    System.out.println(m_shooterSubsystem.getEncoder());
    return false;
  }

/*
  @Override
  public void initialize() {
    //m_shooterSubsystem.resetEncoder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopping");
    m_shooterSubsystem.stop();
   // m_storageSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    if (Math.abs(m_shooterSubsystem.getEncoder()) > 2048*5) {
      return true;
    } 
    return false;
  }*/

}
