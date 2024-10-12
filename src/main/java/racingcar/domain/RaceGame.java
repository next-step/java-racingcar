package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    private final List<String> carNames;

    private final int tryCount;

    public RaceGame(List<String>carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    public List<Records> playGame(final MoveStrategy moveStrategy) {
        Cars cars = new Cars(carNames);

        return playRounds(cars, moveStrategy);
    }

    public List<Records> playRounds(Cars cars, MoveStrategy moveStrategy) {
        List<Records> allRoundRecords = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            Records records = playRound(cars, moveStrategy);
            allRoundRecords.add(records);
        }
        return allRoundRecords;
    }

    public Records playRound(Cars cars, MoveStrategy moveStrategy) {
        Records records = new Records();
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
            records.save(new Record(car.getPosition(), car.getName().getValue()));
        }

        return records;
    }
}
