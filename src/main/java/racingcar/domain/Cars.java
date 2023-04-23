package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public Scores move(NumberGeneratorStrategy numberGeneratorStrategy) {
        Scores scores = new Scores();
        for (Car car : cars) {
            car.move(numberGeneratorStrategy);
            scores.addScore(new Score(car));
        }
        return scores;
    }

    public int findCarsCount() {
        return cars.size();
    }

}
