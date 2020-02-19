/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  private WPI_TalonFX turret = new WPI_TalonFX(TurretConstants.kTurretMotorPort);

  public TurretSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  
  public double getEncoderRate() 
  {
      return turret.getSensorCollection().getIntegratedSensorAbsolutePosition();
  }

  public void turn(boolean direction)
  {
      double power = direction ? TurretConstants.kTurretPower : -1 * TurretConstants.kTurretPower;
      turret.set(power);
  }

  public void stop()
  {
      turret.set(0);
  }

  public boolean isOver()
  {
    if(getEncoderRate() < TurretConstants.kStopTurretRight || getEncoderRate() > TurretConstants.kStopTurretLeft)
    {
      return false;
    }
    return true;
  }
  
}