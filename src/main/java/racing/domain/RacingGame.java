package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int numberOfRound;

    public RacingGame(String carNames, int numberOfRound) {
        if (!isValid(numberOfRound))  {
            throw new IllegalArgumentException();
        }
        this.cars = CarFactory.generateCars(carNames);
        this.numberOfRound = numberOfRound;
    }

    private boolean isValid(final int numberOfRound) {
        return numberOfRound > 0;
    }

    public RacingResult play(final MoveStrategy moveStrategy) {
        final RacingResult racingResult = new RacingResult();

        for (int i = 0; i < numberOfRound; i++) {
            racingResult.add(getRoundResultBy(moveStrategy));
        }
        return racingResult;
    }

    private List<Car> getRoundResultBy(final MoveStrategy moveStrategy) {
        final List<Car> roundResult = new ArrayList<>();

        for (Car car : cars) {
            car.move(moveStrategy.isMovable());
            roundResult.add(car.getClone());
        }
        return roundResult;
    }
}
