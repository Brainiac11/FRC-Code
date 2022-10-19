package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Intake extends SubsystemBase{
     //vs code you are very stupid and idiotiv sendtomicrosoft to fix this imediatily ypoi are bad laggy because of the syupid electron i hate you witha  passion especially java
     public CANSparkMax intakeMotor;
     


     public Intake(int motorID){
          intakeMotor = new CANSparkMax(motorID, MotorType.kBrushless);


     }
     public void move(double speed){
          intakeMotor.set(speed);


     }
     public void stop(){
          intakeMotor.stopMotor();
     }
}
