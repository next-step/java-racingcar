package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int numberOfRound;

    public RacingGame(String carNames, int numberOfRound) {
        NameParser nameParser = new NameParser();

        this.cars = nameParser.parse(carNames);
        this.numberOfRound = numberOfRound;
    }

    public RacingResult play(final MoveStrategy moveStrategy) {
        final RacingResult racingResult = new RacingResult();
        for (int i = 1; i <= numberOfRound; i++) {
            racingResult.put(i, getRoundResultBy(moveStrategy));
        }
        return racingResult;
    }

    private List<Car> getRoundResultBy(final MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.isMovable());
        }
        return cloneCars(cars);
    }

    private List<Car> cloneCars(final List<Car> cars) {
        List<Car> clonedList = new ArrayList<>();
        for (Car car : cars) {
            clonedList.add(new Car(car.getName(), car.getLocation()));
        }
        return clonedList;
    }
}
