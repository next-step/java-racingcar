package step3.racingcar;

import jdk.internal.util.xml.impl.Input;

import java.util.Map;

public class RacingGame {
    private int gameTryCounts;
    private int[] carPositions;

    public int getGameTryCounts() {
        return this.gameTryCounts;
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }

    public void startGame() {
        setGameInformation();
    }

    public void setGameInformation() {
        Map<String, Integer> userInputMap = InputViewProcessor.getUserInputMap();
        int carCounts = userInputMap.get(UserInputMapKey.CAR_COUNTS.getKey());
        this.gameTryCounts = userInputMap.get(UserInputMapKey.GAME_TRY_COUNTS.getKey());
        this.carPositions = new int[carCounts];
    }
}
