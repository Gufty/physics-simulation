import java.util.*;
import java.math.*;
public class physics {
    public static final double K = 8.99 * Math.pow(10, 9);
    public static final double PROTON_MASS = 1.67 * Math.pow(10, -27);
    public static final double ELECTRON_MASS = 9.11 * Math.pow(10, -31);
    private vector force;
    public physics(){
        force = new vector(0,0);
    }
    //I get the electric force between two particles
    public vector forceC(particle a, particle b){
        //Magnitude of electric force
        double f = K * Math.abs(a.getCharge()) * Math.abs(b.getCharge()) / (Math.pow(force.distance(a.getPos(), b.getPos()),2));
        //Split it into x and y components
        double fX = f * Math.cos(force.angle(a.getPos(),b.getPos()));
        double fY = f * Math.sin(force.angle(a.getPos(),b.getPos()));
        //make a vector for the components and return it
        return new vector(fX, fY);
    }

    public void acc(vector f, particle a, particle b){
        vector accA = new vector(0,0);
        vector accB = new vector(0,0);
        //if electron, do it with electron mass
        if(a.getCharge() < 0)
            accA.set(f.getX() / ELECTRON_MASS, f.getY() / ELECTRON_MASS);
        //if proton, do it with proton mass
        else
            accA.set(f.getX() / PROTON_MASS, f.getY() / PROTON_MASS);
        //same goes with this
        if(b.getCharge() < 0)
            accB.set(f.getX() / ELECTRON_MASS, f.getY() / ELECTRON_MASS);
        else
            accB.set(f.getX() / PROTON_MASS, f.getY() / PROTON_MASS);
        //I check how the particles are interacting by categorizing them with repelling or not
        if(isRepeling(a,b)){
            //if a is to the right of b, a gains vel in the +x while b gains velocity in the -x
            if(a.getPosX() > b.getPosX()){
                a.addVelocity(accA.getX(), 0);
                b.addVelocity(-accB.getX(), 0);
            }
            //if b is to the right of a, b gains vel in the +x while a gains velocity in the -x
            else if(a.getPosX() < b.getPosX()){
                b.addVelocity(accB.getX(), 0);
                a.addVelocity(-accA.getX(), 0);
            }
            //if a is on top of b, a gains vel in the +y while b gains velocity in the -y
            if(a.getPosY() > b.getPosY()){
                a.addVelocity(0, accA.getY());
                b.addVelocity(0, -accB.getY());
            }
            //if b is on top of a, b gains vel in the +y while a gains velocity in the -y
            else if(a.getPosX() < b.getPosX()){
                b.addVelocity(accB.getX(), 0);
                a.addVelocity(-accA.getX(), 0);
            }
            
        }
        else{
            //if a is to the right of b, a gains vel in the +x while b gains velocity in the -x
            if(a.getPosX() > b.getPosX()){
                a.addVelocity(-accA.getX(), 0);
                b.addVelocity(accB.getX(), 0);
            }
            //if b is to the right of a, b gains vel in the +x while a gains velocity in the -x
            else if(a.getPosX() < b.getPosX()){
                b.addVelocity(-accB.getX(), 0);
                a.addVelocity(accA.getX(), 0);
            }
            //if a is on top of b, a gains vel in the +y while b gains velocity in the -y
            if(a.getPosY() > b.getPosY()){
                a.addVelocity(0, -accA.getY());
                b.addVelocity(0, accB.getY());
            }
            //if b is on top of a, b gains vel in the +y while a gains velocity in the -y
            else if(a.getPosY()< b.getPosY()){
                b.addVelocity(-accB.getX(), 0);
                a.addVelocity(accA.getX(), 0);
            }
        }
    }
    //checks charge to see if they repel or not
    public boolean isRepeling(particle a, particle b){
        if((a.getCharge() < 0 && b.getCharge() < 0) || (a.getCharge() > 0 && b.getCharge() > 0))
            return true;
        else
            return false;
    }
}
