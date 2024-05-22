package gabehenneman;
import java.awt.Color;

import net.sf.robocode.ui.editor.theme.ColorAndStyle;
import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class GabeHenneman extends Robot{
    public void run(){

        setBodyColor(Color.CYAN);
        setGunColor(Color.CYAN);
        setRadarColor(Color.MAGENTA);
        setBulletColor(Color.MAGENTA);

        while(true){
            double distance = Math.random()*250;
            double angle = Math.random()*45;
            turnRight(angle);
            ahead(distance);
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
            
        }

    }


    public void onScannedRobot(ScannedRobotEvent e){
        turnRight(e.getBearing());
        double distance = e.getDistance();
        if(distance<200)
        {
           fire(3.5);
        }
        else if(distance<500)
        {
           fire(2.5);
        }
        else if(distance<800)
        {
           fire(1.5);
        }
        else
        {
           fire(0.5);
        }
        
    // Inverts the gun direction on each turn
    //gunDirection = -gunDirection;
    // Turn 360 degrees (clockwise or anti clockwise,)
    //setTurnGunRight(360 * gunDirection);
    }
        public void onHitByBullet(HitByBulletEvent e){
            back(10);
            goLeft();
            //double hitleft = Math.random()*300;
            //double hitright= Math.random()*300;
            
        }
    
        public void goLeft(){
            int leftwhile = 1;
            while(leftwhile < 50){
            turnLeft(20);
            ahead(20);
            turnGunRight(360);
            leftwhile +=10;
            }
        }
}