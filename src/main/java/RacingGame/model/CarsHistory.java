package RacingGame.model;

import java.util.*;

public class CarsHistory {
    private final Map<String, List<Position>> carsHistory;
    private final int stageCount;

    public CarsHistory(List<String> carNames, int stageCount) {
        Map<String, List<Position>> history = new HashMap<>();
        for (String name : carNames) {
            history.put(name, new ArrayList<>());
        }

        this.carsHistory = history;
        this.stageCount = stageCount;
    }


    public void addStage(Map<String, Integer> carsNamePostion) {
        for (String name : carsNamePostion.keySet()) {
            this.carsHistory.get(name).add(Position.valueOf(carsNamePostion.get(name)));
        }
    }

    public int StageCount() {
        return this.stageCount;
    }

    public Map<String, List<Position>> getCarsHistory() {
        return Collections.unmodifiableMap(carsHistory);
    }

    public Map<String, Position> getFinalStage() {
        Map<String, Position> finalStageResult = new HashMap<>();
        for (String carName : this.carsHistory.keySet()) {
            finalStageResult.put(carName, this.carsHistory.get(carName).get(stageCount-1));
        }

        return finalStageResult;
    }
}
