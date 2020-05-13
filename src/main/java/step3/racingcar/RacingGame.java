package step3.racingcar;

import java.util.HashMap;

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
        HashMap<String, Integer> userInputMap = InputView.processUserInput();
        saveUserInput(userInputMap);
    }

    public void saveUserInput(HashMap<String, Integer> userInputMap) {
        this.gameTryCounts = userInputMap.get("gameTryCounts");
        this.carPositions = new int[userInputMap.get("numberOfCars")];
    }
}
