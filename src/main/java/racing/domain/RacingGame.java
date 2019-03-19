package racing.domain;

import java.util.*;

public class RacingGame {

    private final static int RANDOM_VALUE_MAX = 10;

    private List<Car> cars = null;
    private int timeToTry;
    private int time = 0;

    public RacingGame(String[] namesOfCars, int timeToTry) {

        int numberOfCar = namesOfCars.length;
        this.timeToTry = timeToTry;
        this.cars = new ArrayList<Car>(numberOfCar);
        for(String name:namesOfCars) {
            cars.add(new Car(0, name));
        }
    }

    public boolean isEnd() {
        if (time >= timeToTry) return false;
        return true;
    }

    private static int generateRandomValue() {
        return new Random().nextInt(RANDOM_VALUE_MAX);
    }

    public RacingResult race() {
        for (Car car:cars) { car.move(generateRandomValue()); }
        time++;
        return new RacingResult(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
