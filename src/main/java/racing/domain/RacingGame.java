package racing.domain;

import common.StringSpliter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int gameCount;
    private final CarMoveStrategy carMoveStrategy;
    private final List<Car> cars = new ArrayList<>();
    private int currentRound;

    public RacingGame(int carCount, int gameCount) {
        this(carCount, gameCount, new CarMoveStrategy(new Random()));
    }

    public RacingGame(int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;
        initRacingCar(carCount);
    }

    public RacingGame(String userNameAnswer, int carCount, int gameCount) {
        this.gameCount = gameCount;
        this.carMoveStrategy = new CarMoveStrategy(new Random());
        this.currentRound = 0;

        final String NAME_SPLIT_DELIMITER = ",";
        String[] userNames = StringSpliter.getSplittedString(userNameAnswer, NAME_SPLIT_DELIMITER);
        initRacingCar(userNames, carCount);
    }

    public boolean isProgress() {
        return this.getCurrentRound() < this.getGameCount();
    }


    public int getGameCount() {
        return gameCount;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    private void initRacingCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void initRacingCar(String[] userNames, int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(userNames[i]));
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public void doRacing() {
        cars.forEach(this::doGame);
        this.currentRound++;
    }

    private void doGame(Car car) {
        int result = carMoveStrategy.getResult();
        car.move(result);
    }
}
