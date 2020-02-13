/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class ClimberSubsystem extends SubsystemBase {
    private WPI_VictorSPX motor = new WPI_VictorSPX(0);
    private double motorPower = 0;
    /**
   * Creates a new ClimbingSubsystem
   */
  public ClimberSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double p) {
    this.motorPower = p;
  }

  public void climb() {
      this.motor.set(MechanismConstants.kClimbUp);
  }

  public void stop() {
      this.motor.set(0);
  }

  public void reverse() {
      this.motor.set(MechanismConstants.kClimbDown);
  }
}
