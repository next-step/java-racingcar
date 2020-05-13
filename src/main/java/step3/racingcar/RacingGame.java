package step3.racingcar;

import java.util.Map;

public class RacingGame {
    private int gameTryCounts;
    private int[] carPositions;

    public int getGameTryCounts() {
        return gameTryCounts;
    }

    public int[] getCarPositions() {
        return carPositions;
    }

    public void startGame() {
        Map<String, Integer> userInputMap = InputViewProcessor.getUserInputMap();
        saveUserInput(userInputMap);
    }

    public void saveUserInput(Map<String, Integer> userInputMap) {
        this.gameTryCounts = userInputMap.get("gameTryCounts");
        this.carPositions = new int[userInputMap.get("numberOfCars")];
    }
}
