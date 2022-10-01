package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Car;
import repository.CarHistory;

import java.util.Random;
import java.util.stream.Collectors;

public class CarRace {

    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;

    public CarRace() {
    }

    public List<Car> updateCurrentLocation(CarHistory carHistory, List<Car> racingCars) {

        List<Car> updatedCarList = new ArrayList<>();
        for (Car car : racingCars) {
            int randomNum = generateRandomNum();
            Car updatedCar = car.move(car, isMovingForward(randomNum));
            updatedCarList.add(updatedCar);
        }
        carHistory.saveCarHistory(updatedCarList);
        return updatedCarList;
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public List<Car> createInitCarList(String[] carNames) {
        return Arrays.stream(carNames).map(Car::createCarWithName).collect(Collectors.toList());
    }

}
