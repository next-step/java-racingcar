package carRacing;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void move(){
        distance++;
    }

    public int getDistanceForPrint(){
        return distance;
    }

}
