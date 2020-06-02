package step4;

import step4.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars cars;
    private MoveStrategy moveStrategy;

    public RacingGame(List<String> carNames, MoveStrategy moveStrategy) {
        cars = new Cars(carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        cars.move(moveStrategy);
    }

    public Cars getCars() {
        return cars;
    }
}
