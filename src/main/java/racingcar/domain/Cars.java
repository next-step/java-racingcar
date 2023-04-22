package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
            cars.add(new Car(carName));
        }
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

    private void validateCarNameLength(String name) {
        if (name.trim().length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 할 수 없습니다");
        }
    }
}
