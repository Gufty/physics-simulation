import java.math.*;
public class particle {
    private double charge;
    private vector position;
    private vector velocity;
    public particle(double charge, vector position, vector velocity){
        this.charge = charge;
        this.position = position;
        this.velocity = velocity;
    }
    public void addVelocity(double accX, double accY){
        velocity.add(accX, accY);
        position.add(velocity.getX(), velocity.getY());
    }
    public double getCharge(){
        return charge;
    }
    public vector getPos(){
        return position;
    }
    public double getPosX(){
        return position.getX();
    }
    public double getPosY(){
        return position.getY();
    }
}
