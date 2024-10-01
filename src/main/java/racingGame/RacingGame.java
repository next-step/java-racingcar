package racingGame;

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

    public List<List<Integer>> run() {
        List<List<Integer>> allStates = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            moveCars();
            allStates.add(getCarPositions());
        }
        return allStates;
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    private List<Integer> getCarPositions() {
        return cars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }

    public int getCarCount() {
        return cars.size();
    }
}