package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class Racing {

    private Cars cars;
    private final List<List<Integer>> result = new ArrayList<>();

    private Racing() {}

    public Racing(int carNumber) {
        this.cars = new Cars(carNumber, new RandomNumberGenerateStrategy(10));
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            cars.moveAll();
            result.add(cars.allPosition());
        }
    }

    public List<List<Integer>> result() {
        return this.result;
    }
}
