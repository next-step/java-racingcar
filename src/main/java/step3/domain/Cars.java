package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(int carCount) {
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void moveAll(int roundTime, MoveRule moveRule) {
        for(Car car : cars) {
            car.move(roundTime, moveRule.canMove());
        }
    }

    public List<Car> getValue() {
        return cars;
    }
}
