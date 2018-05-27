package frc.team6220.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * @author Owen Ryan
 * @author Ashley Kim
 * hi owen
 * TODO code stuff
 */
public class Robot extends IterativeRobot {
    private DifferentialDrive drive;
    private Encoder driveL;
    private Encoder driveR;
    private Joystick Joysitck1;
    private Joystick Joystick2;
    


    @Override
    public void robotInit() { }
    this.drive = new RobotDrive(0, 1);
    @Override
    public void disabledInit() { }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() { }

    @Override
    public void testInit() { }


    @Override
    public void disabledPeriodic() { }
    
    @Override
    public void autonomousPeriodic() { }

    @Override
    public void teleopPeriodic() { }

    @Override
    public void testPeriodic() { }
}