package frc.team6220.robot;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.cscore.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * @author Owen Ryan
 *
 **/
public class Robot extends IterativeRobot {


    /**
     * motor init
     */


    private VictorSPX Ldrive1 = new VictorSPX(1); //1st stage elevator drive (m1)
    private VictorSPX Ldrive2 = new VictorSPX(6); //1st stage elevator drive (m2)
    private VictorSPX Rdrive1 = new VictorSPX(9); //2nd stage elevator drive (m1)
    private VictorSPX Rdrive2 = new VictorSPX(8); //2nd stage elevator Rotational drive (m1)
    private TalonSRX lift1 = new TalonSRX(2); //driving intake motor (left)
    private TalonSRX lift2 = new TalonSRX (3); //driving intake motor (right)
    private TalonSRX claw1 = new TalonSRX (3); //driving intake motor (right)
    private TalonSRX claw2 = new TalonSRX (3); //driving intake motor (right)
    private DigitalInput CubeLim = new DigitalInput (1);
    private DigitalInput StageLim1 = new DigitalInput(2);
    private DigitalInput StageLim2 = new DigitalInput(2);

    /**
     * misc init
     */
    private Joystick js1;
    private Joystick js2;

    public Robot() {



    }

    @Override
    public void robotInit (){

        js1 = new Joystick(0);
        js2 = new Joystick(1);
        UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);

        MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);

        mjpegServer1.setSource(usbCamera); CvSink cvSink = new CvSink("opencv_USB Camera 0");

        mjpegServer1.setSource(usbCamera);

        CvSource outputStream = new CvSource("Blur", VideoMode.PixelFormat.kMJPEG, 640, 480, 30);

        MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);

        mjpegServer2.setSource(outputStream);
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

        /**
         *
         * chassis control
         *
         */
        if(js1.getTrigger()){
            Ldrive1.set(ControlMode.PercentOutput, js1.getY());    }
        if(!js1.getTrigger()){
            Ldrive1.set(ControlMode.PercentOutput, 0);
        }
        if(js1.getTrigger()){
            Ldrive2.set(ControlMode.PercentOutput, js1.getY());    }
        if(!js1.getTrigger()){
            Ldrive2.set(ControlMode.PercentOutput, 0);
        }

        if(js2.getTrigger()){
            Rdrive1.set(ControlMode.PercentOutput, js2.getY());    }
        if(!js2.getTrigger()){
            Rdrive1.set(ControlMode.PercentOutput, 0);
        }
        if(js2.getTrigger()){
            Rdrive2.set(ControlMode.PercentOutput, js2.getY());    }
        if(!js2.getTrigger()){
            Rdrive2.set(ControlMode.PercentOutput, 0);
        }

        /**
         * elevator control (manual)
         */
        while(js1.getRawButton(1)&&js2.getRawButton(1)&&!(StageLim1.get()||StageLim2.get())){
            lift1.set(ControlMode.PercentOutput, (js1.getThrottle()+js2.getThrottle())/2);
            lift2.set(ControlMode.PercentOutput, (js1.getThrottle()+js2.getThrottle())/2);
        }
        while(js1.getRawButton(0)&&js2.getRawButton(0)){
            lift1.set(ControlMode.PercentOutput, -(js1.getThrottle()+js2.getThrottle())/2);
            lift2.set(ControlMode.PercentOutput, -(js1.getThrottle()+js2.getThrottle())/2);
        }
        /**
         * intake control (manual)
         */
        if(js1.getRawButton(2)&&js2.getRawButton(2)){
            for(int i = 0; i<10; i++){
                if(!CubeLim.get()){
                claw1.set(ControlMode.PercentOutput, 1);
                claw2.set(ControlMode.PercentOutput, 1);
                }else{
                    claw1.set(ControlMode.PercentOutput, 0);
                    claw2.set(ControlMode.PercentOutput, 0);
                }
            }
        }
    }


    @Override
    public void testPeriodic() { }
}