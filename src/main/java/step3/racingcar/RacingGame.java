package step3.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int gameTryCounts;
    private final List<RacingCar> racingCarList = new ArrayList<>();

    public int getGameTryCounts() {
        return this.gameTryCounts;
    }

    public List<RacingCar> getRacingCarList() {
        return this.racingCarList;
    }

    public void startGame() {
        setGameInformation();
    }

    public void setGameInformation() {
        Map<String, Integer> userInputMap = InputViewProcessor.getUserInputMap();
        int carCounts = userInputMap.get(UserInputMapKey.CAR_COUNTS.getKey());
        this.gameTryCounts = userInputMap.get(UserInputMapKey.GAME_TRY_COUNTS.getKey());
        setRacingCarList(carCounts);
    }

    public void setRacingCarList(int carCounts) {
        for (int i = 0; i < carCounts; i++) {
            RacingCar racingCar = new RacingCar();
            this.racingCarList.add(racingCar);
        }
    }
}
