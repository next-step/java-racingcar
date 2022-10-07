package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.strategy.NumberGenerateStrategy;

public class Racing {

    private Cars cars;
    private final List<List<RacingResult>> result = new ArrayList<>();

    private Racing() {}

    public Racing(List<String> carNames, NumberGenerateStrategy strategy) {
        this.cars = new Cars(carNames, strategy);
    }

    public List<List<RacingResult>> result() {
        return this.result;
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            cars.moveAll();
            saveCurrentResult();
        }
    }

    private void saveCurrentResult() {
        List<RacingResult> currentResult = new ArrayList<>();
        cars.carList().forEach(car ->
            currentResult.add(RacingResult.from(car))
        );
        result.add(currentResult);
    }

    public List<String> winners() {
        int maxPosition = cars.maxPosition();
        return cars.carList().stream()
            .filter(car -> car.position() == maxPosition)
            .map(Car::name)
            .collect(Collectors.toList());
    }
}
