/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Dlock
 */
public abstract class BTShooter {
    
    // extends shooter pistons
    public abstract void shoot(boolean canShoot);
    
    // sets motor speed to zero
    public abstract void killShot();
    
    // sets the speed of the motor
    public abstract void setSpeed(boolean set, double speed);
    
    // shoots the frisbee
    public abstract void update(ControlBoard cb);
    
    public void init() {
        // evaluate switch
        // if (switch), instantiate RadialShooter()
        // else instantiate LinearShooter()
    }
}
