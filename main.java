import java.util.*;
import java.math.*;

public class main{
    public static void main(String[] args) {
        double charge = 1.602 * Math.pow(10, -19);
        particle electron = new particle(-charge, new vector(0, 0), new vector(0, 0));
        particle proton = new particle(charge, new vector(10,0), new vector(0,0));
        physics math = new physics();
        for(int i = 0; i < 10; i++){
            System.out.println("Electron position: " + electron.getPosX());
            System.out.println("Proton position: " + proton.getPosX());
            System.out.println("Force: " + math.forceC(electron, proton));
            math.acc(math.forceC(electron, proton), electron, proton);
        }
    }
}
