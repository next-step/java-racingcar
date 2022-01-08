package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private static final String SPLIT_COMMA = ",";

    public Cars(String carsName) {
        splitCarsName(carsName);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void addCars(String carName) {
        Car car = new Car(carName);
        this.cars.add(car);
    }

    public void splitCarsName(String carsNames) {
        String[] carName = carsNames.split(SPLIT_COMMA);
        for (String name : carName) {
            addCars(name);
        }
    }

    public List<Car> carsMove() {
        for (Car car : cars) {
            car.move(new RandomNumberMovingStrategy());
        }
        return Collections.unmodifiableList(cars);
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = checkMaxDistance(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    public int checkMaxDistance(int maxDistance, int carDistance) {
        if (carDistance > maxDistance) {
            return carDistance;
        }
        return maxDistance;
    }

    public List<String> findMaxDistanceCar(int maxDistance) {
        final Winner winner = new Winner();
        for (Car car : cars) {
            winner.findWinnerCar(car, maxDistance);
        }
        return Collections.unmodifiableList(winner.getWinnerCar());
    }

}
