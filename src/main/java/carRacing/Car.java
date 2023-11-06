package carRacing;


import static carRacing.MovingStrategy.*;

public class Car {
    private int distance = 0;
    private MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public Car(int distance, MovingStrategy movingStrategy) {
        this.distance = distance;
        this.movingStrategy = movingStrategy;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int number) {
        if (movingStrategy.isRide(number)) {
            distance++;
        }
    }
}
