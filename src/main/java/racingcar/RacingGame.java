package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<String> roundResults = new ArrayList<>();

    public RacingGame(List<String> carNames) {
        this(Cars.fromCarNames(carNames));
    }

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void drive(int roundAmount, DrivingStrategy drivingStrategy) {
        Round round = new Round(roundAmount);
        for (int i = 0; i < round.value(); i++) {
            cars.drive(drivingStrategy);
            roundResults.add(cars.result());
        }
    }

    public List<Integer> drivingDistances() {
        return cars.drivingDistances();
    }

    public String result() {
        return String.join("\n\n", roundResults);
    }

    public List<String> winnerNames() {
        return cars.winners().names();
    }
}
