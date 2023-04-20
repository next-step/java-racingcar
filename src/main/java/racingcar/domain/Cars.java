package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String carName) {
        cars = new ArrayList<>();
        createCars(carName);
    }

    public Scores move(NumberGeneratorStrategy numberGeneratorStrategy) {
        Scores scores = new Scores();
        for (Car car : cars) {
            car.move(numberGeneratorStrategy);
            scores.addScore(car);
        }
        return scores;
    }

    public int findCarsCount() {
        return cars.size();
    }

    private List<Car> createCars(String carName) {
        String[] name = carName.split(DELIMITER);
        for (int i = 0; i < name.length; i++) {
            Car car = new Car(name[i]);
            cars.add(car);
        }
        return cars;
    }

}
