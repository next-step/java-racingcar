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

    public void run() {
        Map<String, Integer> userInputMap = InputViewProcessor.getUserInputMap();
        setGameInformation(userInputMap);
        startGame();
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

    public void startGame() {
        List<RacingCar> racingCars = getRacingCarList();
        for (int i = 0; i < this.gameTryCounts; i++) {
            moveByRandomNumber(racingCars);
            ResultViewProcessor.printResult(racingCars);
        }
    }

    public void moveByRandomNumber(List<RacingCar> racingCarList) {
        for (int i = 0; i < racingCarList.size(); i++) {
            int randomNumber = (int)(Math.random() * 10);
            validateMove(i, randomNumber);
        }
    }

    public void validateMove(int i, int randomNumber) {
        if (randomNumber >= 4)
            this.getRacingCarList().get(i).movePosition();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.run();
    }
}
