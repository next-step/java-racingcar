package car.entity;

import car.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final static String UNDEFINED_CAR_NAME = "undefined";
    public List<Car> racingCars;

    public RacingGame(String[] carsName) {
        racingCars = createRacingCars(carsName);
    }

    private List<Car> createRacingCars(String[] carsName) {
        List<Car> cars = new ArrayList<>();

        int i = 0;
        while (i < carsName.length) {
            String name = carsName[i] == "" ? UNDEFINED_CAR_NAME : carsName[i];
            cars.add(Car.getCarInstance(name));
            i ++;
        }
        return cars;
    }

    public GameResult playingGame() {
        move();
        return GameResult.createResultInstance(racingCars);
    }

    private void move() {
        racingCars.stream().forEach(car -> {
            car.move(RandomNumber.getNumber());
        });
    }
}
