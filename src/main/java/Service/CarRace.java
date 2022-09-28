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

    private static List<Car> racingCars;

    public CarRace() {
    }
    public CarRace(List<Car> racingCars) {
        CarRace.racingCars = racingCars;
    }

    public static void updateCurrentLocation() {
        int randomNum = generateRandomNum();
        racingCars.forEach(it -> it.move(isMovingForward(randomNum)));
    }

    private static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private static boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

    public void createInitCarList(String[] carNames) {
        racingCars = Arrays.stream(carNames).map(Car::createCar).collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
