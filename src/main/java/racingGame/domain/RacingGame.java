package racingGame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int attempts;

    public RacingGame(String[] carNames, int attempts, MovementCondition movementCondition) {
        this.cars = Arrays.stream(carNames)
                .map(name -> new RacingCar(name, movementCondition))
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public GameResult run() {
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            moveCars();
            roundResults.add(new RoundResult(takeSnapshot()));
        }

        return new GameResult(roundResults);
    }


    private void moveCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    private List<RacingCar> takeSnapshot() {
        return cars.stream()
                .map(car -> new RacingCar(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public int getCarCount() {
        return cars.size();
    }

}