package step4.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racing.Car;
import utils.RandomUtils;

public class RacingGame {
    private Cars cars;
    private int maxRandomNumber;
    private RandomUtils randomUtils;

    public RacingGame(String carNames, int maxRandomNumber) {
        this.maxRandomNumber = maxRandomNumber;
        List<Car> carList = createCars(carNames);
        this.cars = new Cars(carList);
        Random random = new Random();
        this.randomUtils = new RandomUtils(random);
    }

    private static List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(new NameCar(name));
        }
        return cars;
    }

    public String[] carNames() {
        return cars.carNames();
    }

    public Cars cars() {
        return cars;
    }

    public List<String> winners() {
        return cars.winners();
    }

    public void rollTheDice() {
        cars.rollTheDice(randomUtils, maxRandomNumber);
    }

}
