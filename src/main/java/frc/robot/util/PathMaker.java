package frc.robot.util;

import java.util.HashMap;
import java.util.Set;

import com.pathplanner.lib.PathPlanner;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Swerve.SwerveDrive;

public class PathMaker {
    private static HashMap<String, PratsSwerveControllerCommand> commandList = new HashMap<String, PratsSwerveControllerCommand>();
    private static SwerveDrive driveTrain;
    private static PIDController xTranslationPID, yTranslationPID;
    private static PIDController thetaPID;

    public static void initPaths(String... sArgs) {
        Set<String> args = Set.of(sArgs);
        xTranslationPID = new PIDController(Constants.SwerveConstants.AUTON_TRANSLATION_P, 0, 0);
        yTranslationPID = new PIDController(Constants.SwerveConstants.AUTON_TRANSLATION_P, 0, 0);
        thetaPID = new PIDController(Constants.SwerveConstants.AUTON_THETA_P, 0, 0);
        driveTrain = RobotContainer.getSwerve();
        args.forEach((name) -> {
            commandList.put(name, new PratsSwerveControllerCommand(
                PathPlanner.loadPath(name, Constants.SwerveConstants.MAX_AUTON_SPEED_M_PER_S, Constants.SwerveConstants.MAX_AUTON_ACCEL_M_PER_S2), 
                driveTrain::getPose, 
                Constants.SwerveConstants.SWERVE_DRIVE_KINEMATICS, 
                xTranslationPID,
                yTranslationPID,
                thetaPID,
                driveTrain::setModules,
                driveTrain::stopMods,
                driveTrain)
            );
        });
    }

    public static PratsSwerveControllerCommand getCommand(String name) {
        return commandList.get(name);
    }

    public static void resetPaths() {
        Set<String> s = commandList.keySet();
        commandList.clear();
        initPaths(s.toArray(String[]::new));
    }
}
