package Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Car;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRace {


    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;
    private List<Car> racingCars;

    public CarRace() {
    }

    public List<Car> updateCurrentLocation(List<Car> racingCars) {
        int randomNum = generateRandomNum();

        for (int i = 0; i < racingCars.size(); i ++) {
            this.racingCars.set(i, racingCars.get(i).move(isMovingForward(randomNum)));
        }
        return this.racingCars;
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public void createInitCarList(String[] carNames) {
        this.racingCars = Arrays.stream(carNames).map(Car::createCar).collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return this.racingCars;
    }
}
