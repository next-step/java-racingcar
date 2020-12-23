package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for(int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i]));
        }
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

    public void moveAll(int roundTime, MoveRule moveRule) {
        cars.forEach(car -> car.move(roundTime, moveRule.canMove()));
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(cars);
    }
}
