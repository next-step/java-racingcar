package step3.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private int carCounts;
    private int gameTryCounts;
    private static final int RANDOM_NUMBER_RANGE_MAX = 10;
    private static final int RANDOM_NUMBER_LIMIT = 4;

    public void run() {
        setGameInformation();
        List<RacingCar> racingCars = CarFactory.makeCars(this.carCounts);
        startGame(racingCars, gameTryCounts);
    }

    public void setGameInformation() {
        this.carCounts = InputViewProcessor.getUserInput(Message.CAR_COUNTS);
        this.gameTryCounts = InputViewProcessor.getUserInput(Message.GAME_TRY_COUNTS);
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
            int randomNumber = (int)(Math.random() * RANDOM_NUMBER_RANGE_MAX);
            RacingCar racingCar = racingCars.get(i);
            moveRacingCarByRandomNumber(racingCar, randomNumber);
        }
    }

    public void moveRacingCarByRandomNumber(RacingCar racingCar, int randomNumber) {
        if (randomNumber >= RANDOM_NUMBER_LIMIT)
            racingCar.movePosition();
    }
}
