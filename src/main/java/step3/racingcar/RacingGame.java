package step3.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int gameTryCounts;
    private List<RacingCar> racingCars;

    public int getGameTryCounts() {
        return this.gameTryCounts;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public void run() {
        Map<String, Integer> userInputMap = InputViewProcessor.getUserInputMap();
        setGameInformation(userInputMap);
        List<RacingCar> racingCars = getRacingCars();
        int gameTryCounts = getGameTryCounts();
        startGame(racingCars, gameTryCounts);
    }

    public void setGameInformation(Map<String, Integer> userInputMap) {
        int carCounts = userInputMap.get(UserInputMapKey.CAR_COUNTS.getKey());
        int gameTryCounts = userInputMap.get(UserInputMapKey.GAME_TRY_COUNTS.getKey());
        setGameTryCounts(gameTryCounts);
        setRacingCars(carCounts);
    }

    public void setGameTryCounts(int gameTryCounts) {
        this.gameTryCounts = gameTryCounts;
    }

    public void setRacingCars(int carCounts) {
        this.racingCars = new ArrayList<>();
        for (int i = 0; i < carCounts; i++) {
            RacingCar racingCar = new RacingCar();
            this.racingCars.add(racingCar);
        }
    }

    public void startGame(List<RacingCar> racingCars, int gameTryCounts) {
        for (int i = 0; i < gameTryCounts; i++) {
            makeRandomNumber(racingCars);
            ResultViewProcessor.printResult(racingCars);
        }
    }

    public void makeRandomNumber(List<RacingCar> racingCars) {
        int carCounts = racingCars.size();
        for (int i = 0; i < carCounts; i++) {
            int randomNumber = (int)(Math.random() * 10);
            RacingCar racingCar = racingCars.get(i);
            moveRacingCarByRandomNumber(racingCar, randomNumber);
        }
    }

    public void moveRacingCarByRandomNumber(RacingCar racingCar, int randomNumber) {
        if (randomNumber >= 4)
            racingCar.movePosition();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.run();
    }
}
