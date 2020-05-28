package racingcar_step4;

import java.util.Random;

public class Car implements Comparable<Car>{

    private String carName;
    private int totalDistance;

    public Car() {
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int totalDistance) {
        this.carName = carName;
        this.totalDistance = totalDistance;
    }

    public int move() {
        int randomNumber = getRandom ();
        if(randomNumber >= CarRacingConstants.MOVE_POSSIBLE_VALUE) {
            return totalDistance += CarRacingConstants.FORWARD_VALUE;
        }
        return totalDistance;
    }

    private int getRandom() {
        Random rand = new Random();
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
