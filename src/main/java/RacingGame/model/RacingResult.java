package RacingGame.model;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingResult {
    private final CarsHistory carsHistory;

    public RacingResult(List<String> carNameList, int stages) {
        this.carsHistory = new CarsHistory(carNameList, stages);
    }

    public void addStage(Map<String, Integer> carNamePositions) {
        carsHistory.addStage(carNamePositions);
    }

    public CarsHistory getHistories() {
        return carsHistory;
    }

    public List<String> winners() {
        return findWinners(carsHistory.getFinalStage());
    }

    private List<String> findWinners(Map<String, Position> finalStageResult) {
        int highestPosition = findHighestPosition(finalStageResult);

        return finalStageResult.entrySet().stream()
                .filter(entry -> entry.getValue().getPosition() == highestPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int findHighestPosition(Map<String, Position> finalStageResult) {
        return finalStageResult.values()
                .stream()
                .mapToInt(Position::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
