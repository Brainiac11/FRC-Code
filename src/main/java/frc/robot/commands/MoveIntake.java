package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveIntake extends CommandBase {
    public MoveIntake(){

    }
    @Override
    public void initialize(){
        addRequirements(RobotContainer.getIntake());
        
    }
    @Override
    public void execute(){
        RobotContainer.getIntake().move(1);

    }
    @Override
    public boolean isFinished(){
        return !RobotContainer.getJoystick().getRawButton(2);
    }
    @Override
    public void end(boolean interrupted){
        RobotContainer.getIntake().stop();
    }
}
