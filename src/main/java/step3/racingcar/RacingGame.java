package step3.racingcar;

import java.util.List;

public class RacingGame {
    private int carCounts;
    private int gameTryCounts;
    private static final int RANDOM_NUMBER_RANGE_MAX = 10;
    private static final int RANDOM_NUMBER_LIMIT = 4;

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

    public void makeRandomNumber(List<Car> cars) {
        int carCounts = cars.size();
        for (int i = 0; i < carCounts; i++) {
            int randomNumber = (int)(Math.random() * RANDOM_NUMBER_RANGE_MAX);
            Car car = cars.get(i);
            moveRacingCarByRandomNumber(car, randomNumber);
        }
    }

    public void moveRacingCarByRandomNumber(Car car, int randomNumber) {
        if (randomNumber >= RANDOM_NUMBER_LIMIT)
            car.movePosition();
    }
}
