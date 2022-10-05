package service;

import domain.Car;
import java.util.List;
import java.util.Random;

public class CarRace {

    private static final int MAX_LIMIT_BOUND_NUMBER = 10;
    private static final String DASH = "-";
    private static final String DELIMITER = " : ";

    public List<Car> updateCurrentLocation(List<Car> cars) {

        for (Car car : cars) {
            int randomNum = generateRandomNum();
            car.move(randomNum);
        }
        return cars;
    }

    public void printCarLocationPerAttempt(List<Car> carList) {
        List<Car> cars = updateCurrentLocation(carList);
        for (Car car : cars) {
            System.out.println(
                car.getCarName() + DELIMITER + convertLocationToDash(car.getCurrentLocation()));
        }
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private String convertLocationToDash(int location) {
        return DASH.repeat(location);
    }

}
