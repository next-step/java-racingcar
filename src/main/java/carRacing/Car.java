package carRacing;


import static carRacing.MovingStrategy.*;

public class Car {
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public void move(int number) {
        if (isRide(number)) {
            distance++;
        }
    }
}
