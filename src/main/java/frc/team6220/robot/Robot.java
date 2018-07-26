package frc.team6220.robot;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * @author Owen Ryan
 * @author Ashley Kim
 *
**/
public class Robot extends IterativeRobot {
    private DifferentialDrive memeBot;
    /**
     * motor init
     */
    private VictorSP elev1 = new VictorSP(1); //1st stage elevator drive (m1)
    private VictorSP elev2 = new VictorSP(2); //1st stage elevator drive (m2)
    private VictorSP elev3 = new VictorSP(3); //2nd stage elevator drive (m1)
    private VictorSP elev4 = new VictorSP(6); //2nd stage elevator Rotational drive (m1)
    private VictorSP claw1 = new VictorSP(4); //driving intake motor (left)
    private VictorSP claw2 = new VictorSP(5); //driving intake motor (right)
    private Talon Ldrive1= new Talon(1); //front left Drive motor
    private Talon Ldrive2= new Talon(2); //back left drive motor
    private Talon Rdrive1= new Talon(3); //front right drive motor
    private Talon Rdrive2= new Talon(4); //back right drive motor
    private SpeedControllerGroup LGRP = new SpeedControllerGroup(Ldrive1,Ldrive2);
    private SpeedControllerGroup RGRP = new SpeedControllerGroup(Rdrive1,Rdrive2);

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
    //if you dont give a dog a leash it will run into the street and die. Now I dont ever want that happening to a robit
        System.out.println("Exception in thread \"Robot\" java.lang.NullPointerException there are no errors");
        memeBot = new DifferentialDrive(LGRP, RGRP);
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

        memeBot.arcadeDrive(js.getX(GenericHID.Hand.kLeft), js.getY(GenericHID.Hand.kRight) - (js.getY(GenericHID.Hand.kLeft)));
        elev1.set( js.getThrottle());//elevator height
        elev2.set( js.getThrottle());//elevator height
        if(js.getTrigger() && !intake){//intake cube
            claw1.set(1);
            claw2.set(1);
            intake = true;
        }
        if(js.getTrigger() && intake){//outtake cube
            claw1.set(-1);
            claw2.set(-1);
            intake = false;
        }
        if(js.getRawButton(1)&& stage2){

            for(int i = 0; i<=10/*the number of seconds of freedom 2nd stage has*/; i++) {
                elev3.set(1);
            }
            stage2=false;
        }
        if(js.getRawButton(1)&& !stage2) {

            for (int i = 0; i <= 10/*the number of seconds of freedom 2nd stage has*/; i++) {
                elev3.set(-1);
            }
            stage2 = true;
        }
        if(js.getRawButton(1)&& roll){

            for(int i = 0; i<=10/*the number of seconds of freedom 2nd stage has*/; i++) {
                elev4.set(1);
            }
            roll=false;
        }
        if(js.getRawButton(1)&& !roll) {

            for (int i = 0; i <= 10/*the number of seconds of freedom 2nd stage has*/; i++) {
                elev4.set(-1);
            }
            roll= true;
        }
    }

    @Override
    public void testPeriodic() { }
}