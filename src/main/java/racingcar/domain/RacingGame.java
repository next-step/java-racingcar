package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private InputCarCount carCount;
    private InputRoundCount roundCount;
    private List<Car> cars;

    public RacingGame(InputCarCount carCount, InputRoundCount roundCount) {
        if (carCount == null || roundCount == null) {
            throw new IllegalArgumentException();
        }

        this.carCount = carCount;
        this.roundCount = roundCount;
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount.getCarCount(); i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int play() {
        int tryCount = 0;
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            tryCount++;
        }
        return tryCount;
    }
}
