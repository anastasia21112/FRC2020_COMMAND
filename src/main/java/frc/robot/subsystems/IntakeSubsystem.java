/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.MechanismConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class IntakeSubsystem extends SubsystemBase 
{
  /**
   * Creates a new ExampleSubsystem.
   */
  WPI_VictorSPX intakeVictor = new WPI_VictorSPX(MechanismConstants.kIntakeVictor);
  Solenoid solenoid = new Solenoid(MechanismConstants.kIntakeSolenoid);
  public IntakeSubsystem()
  {

  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
  public void extend(boolean enabled)
  {
      this.solenoid.set(enabled);
  }
  public void spin()
  {
      this.intakeVictor.set(MechanismConstants.kIntakeSpin);
  }
  public void stop()
  {
      this.intakeVictor.set(0);
  }
}
