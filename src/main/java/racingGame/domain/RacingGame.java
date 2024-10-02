package racingGame.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int attempts;
    private List<String> winners = Collections.emptyList();

    public RacingGame(String[] carNames, int attempts, MovementCondition movementCondition) {
        this.cars = Arrays.stream(carNames)
                .map(name -> new RacingCar(name, movementCondition))
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public List<Map<String, Integer>> run() {
        List<Map<String, Integer>> roundsWithCarPosition = new ArrayList<>();
        for (int i = 0; i < attempts; i++) {
            moveCars();
            roundsWithCarPosition.add(getCarPositions());
        }

        Map<String, Integer> finalStates = roundsWithCarPosition.get(roundsWithCarPosition.size() - 1);
        determineWinners(finalStates);

        return roundsWithCarPosition;
    }

    private void determineWinners(Map<String, Integer> finalStates) {
        int maxPosition = Collections.max(finalStates.values());

        winners = finalStates.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void moveCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    private Map<String, Integer> getCarPositions() {
        return cars.stream()
                .collect(Collectors.toMap(RacingCar::getName, RacingCar::getPosition));
    }

    public int getCarCount() {
        return cars.size();
    }

    public List<String> getWinners() {
        return List.copyOf(winners);
    }
}