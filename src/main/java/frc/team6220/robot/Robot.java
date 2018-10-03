package frc.team6220.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * @author Owen Ryan
 *
 **/
public class Robot extends IterativeRobot {
     private DifferentialDrive memeBot;



    /**
     * motor init
     */

    private VictorSPX elev1 = new VictorSPX(1); //1st stage elevator drive (m1)
    private VictorSPX elev2 = new VictorSPX(6); //1st stage elevator drive (m2)
    private VictorSPX elev3 = new VictorSPX(9); //2nd stage elevator drive (m1)
    private VictorSPX elev4 = new VictorSPX(8); //2nd stage elevator Rotational drive (m1)
    private VictorSP claw1 = new VictorSP(4); //driving intake motor (left)
    private VictorSP claw2 = new VictorSP(5); //driving intake motor (right)
    private TalonSRX Ldrive1= new TalonSRX(1); //front left Drive motor
    private TalonSRX Ldrive2= new TalonSRX(30); //back left drive motor
    private TalonSRX Rdrive1= new TalonSRX(10); //front right drive motor
    private TalonSRX Rdrive2= new TalonSRX(3); //back right drive motor
    //private SpeedControllerGroup LGRP = new SpeedControllerGroup(Ldrive1,Ldrive2);
    //private SpeedControllerGroup RGRP = new SpeedControllerGroup(Rdrive1,Rdrive2);

    /**
     * misc init
     */
    private Joystick js;
    int elevatorTick = 0;
    private boolean intake = false;
    private boolean stage2 = false;
    private boolean roll = false;

    @Override
    public void robotInit () /*throws NullPointerException*/ {
        //memeBot = new DifferentialDrive(Ldrive1, Ldrive2);
        js = new Joystick(0);

    }

    @Override
    public void disabledInit() {    }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() {

    }

    @Override
    public void testInit() { }


    @Override
    public void disabledPeriodic() { }

    @Override
    public void autonomousPeriodic() { }

    @Override
    public void teleopPeriodic() {
        if(js.getTrigger()){
            elev1.set(ControlMode.PercentOutput, js.getY());    }
        if(!js.getTrigger()){
            elev1.set(ControlMode.PercentOutput, 0);
        }
        if(js.getTrigger()){
            elev2.set(ControlMode.PercentOutput, js.getY());    }
        if(!js.getTrigger()){
            elev2.set(ControlMode.PercentOutput, 0);
        }

        if(js.getTrigger()){
            elev3.set(ControlMode.PercentOutput, js.getX());    }
        if(!js.getTrigger()){
            elev3.set(ControlMode.PercentOutput, 0);
        }
        if(js.getTrigger()){
            elev4.set(ControlMode.PercentOutput, js.getX());    }
        if(!js.getTrigger()){
            elev4.set(ControlMode.PercentOutput, 0);
        }
    }


    @Override
    public void testPeriodic() { }
}