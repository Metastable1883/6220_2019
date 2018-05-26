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
    Talon exampleTalon0 = new Talon(1);
    Talon exampleTalon1 = new Talon(2);
    Talon exampleTalon2 = new Talon(3);
    Talon exampleTalon3 = new Talon(4);
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