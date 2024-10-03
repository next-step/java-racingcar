package racinggame.racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {
    private final RacingCars racingCars;

    private Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Race create(MoveStrategy moveStrategy, List<String> carNames) {
        RacingCars racingcars = RacingCars.create(moveStrategy, carNames);
        return new Race(racingcars);
    }

    public void proceedRound() {
        racingCars.moveAll();
    }

    public Map<String, Integer> collectResults() {
        return racingCars.getCarsInfo();
    }

    public List<String> determineWinners() {
        Map<String, Integer> results = collectResults();
        int maxPosition = findMaxPosition(results);
        return findWinners(results, maxPosition);
    }

    private int findMaxPosition(Map<String, Integer> results) {
        return results.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> findWinners(Map<String, Integer> results, int maxPosition) {
        return results.entrySet().stream()
                .filter(entry -> isMaxPosition(entry, maxPosition))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean isMaxPosition(Map.Entry<String, Integer> entry, int maxPosition) {
        return entry.getValue() == maxPosition;
    }
}
