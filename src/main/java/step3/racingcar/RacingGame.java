package step3.racingcar;

import java.util.List;

public class RacingGame {
    private int carCounts;
    private int gameTryCounts;

    public void run() {
        setGameInformation();
        List<Car> cars = CarFactory.makeCars(this.carCounts);
        startGame(cars);
    }

    public void setGameInformation() {
        this.carCounts = InputViewProcessor.getUserInput(Message.CAR_COUNTS);
        this.gameTryCounts = InputViewProcessor.getUserInput(Message.GAME_TRY_COUNTS);
    }

    public void startGame(List<Car> cars) {
        for (int i = 0; i < gameTryCounts; i++) {
            makeRandomNumber(cars);
            ResultViewProcessor.printResult(cars);
        }
    }

    public void moveRacingCarByRandomNumber(Car car, int randomNumber) {
        if (randomNumber >= RANDOM_NUMBER_LIMIT)
            car.movePosition();
    }
}
