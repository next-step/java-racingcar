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

    public Cars play() {
        cars.getCars().forEach(it -> {
            calcMove(it);
        });
        return cars;
    }

    private void calcMove(Car car) {
        if (moveStrategy.move()) car.move();
    }

    public List<String> calcWinner(Cars cars) {
        int maxPosition = cars.getCars().stream().mapToInt(Car::getPosition).max().getAsInt();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
