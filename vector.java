import java.math.*;
//imports the bigdecimalmath class so we can do double math and not have to blow our brains bc of all of the math we need to know bc of it
public class vector {
    private double x, y;
    public vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public void add(double addX, double addY){
        x += addX;
        y += addY;
    }
    public void set(double addX, double addY){
        x = addX;
        y = addY;
    }
    public double getY(){
        return y;
    }
    //gets the distance between two particles
    public double distance(vector a, vector b){
        //change in x
        double xDiff = b.getX()- a.getX();
        //change in y
        double yDiff = b.getY() - a.getY();
        //pytheogorean theorem
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }
    public double angle(vector a, vector b){
        //change in x
        double xDiff = b.getX() - a.getX();
        //change in y
        double yDiff = b.getY() - a.getY();
        //return the angle
        System.out.println("angle: " + Math.atan(yDiff / xDiff));
        return Math.atan(yDiff / xDiff);
    }
    @Override
    public String toString(){
        return "x: " + getX() + "\ty: " + getY();
    }
}
