package racingcar_step4;

import java.util.Random;

public class Car implements Comparable<Car>{

    private String carName;
    private int totalDistance = 0;

    private Random rand = new Random();

    public Car() {
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int totalDistance) {
        this.carName = carName;
        this.totalDistance = totalDistance;
    }

    public boolean move() {
        int randomNumber = getRandom ();
        if(randomNumber >= CarRacingConstants.MOVE_POSSIBLE_VALUE) {
            totalDistance += CarRacingConstants.FORWARD_VALUE;
            return true;
        }
        return false;
    }

    private int getRandom() {
        return rand.nextInt(CarRacingConstants.RANDOM_RANGE);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return this.totalDistance - car.totalDistance;
    }
}
