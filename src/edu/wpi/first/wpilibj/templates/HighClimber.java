/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author alec
 */
public class HighClimber extends BTClimber implements Constants{
    Piston shortArm;
    Piston longArm;
    Piston tiltPiston;
    
    public HighClimber() {
        shortArm = new Piston(HIGH_SHORT_ARM_EXTEND_PORT, HIGH_SHORT_ARM_RETRACT_PORT);
        longArm = new Piston(HIGH_LONG_EXTEND_PORT, HIGH_LONG_RETRACT_PORT);
        tiltPiston = new Piston(HIGH_TILT_EXTEND_PORT, HIGH_TILT_RETRACT_PORT);
    }
    
    public void update(ControlBoard cb) {
        
        if (cb.canClimb())
        {
            run();
        }
        
    }
    public void run()
    {
        tilt();
        highPull();
        for (int i = 0; i<2; i++)
        {
            lowPull();
            highPull();
        }
    }
    public void tilt()
    {
        tiltPiston.setPistonState(true);
        wait(500);
        lowPull();
        tiltPiston.setPistonState(false);
        
    }
    public void lowPull() {
        shortArm.setPistonState(true);
        wait(1000);
        shortArm.setPistonState(false);
        wait(1000);
    }
    
    public void highPull() {
        shortArm.setPistonState(true);
    }

    public void retract() {
       if(shortArm.get() && longArm.get()) {
        shortArm.setPistonState(false);
        longArm.setPistonState(false);
        }
    }
    
    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch(Exception e) {
            
        }
    }
}
