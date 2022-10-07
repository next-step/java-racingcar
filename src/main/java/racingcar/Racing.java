package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.NumberGenerateStrategy;

public class Racing {

    private Cars cars;
    private final List<List<Integer>> result = new ArrayList<>();

    private Racing() {}

    public Racing(List<String> carNames, NumberGenerateStrategy strategy) {
        this.cars = new Cars(carNames, strategy);
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
