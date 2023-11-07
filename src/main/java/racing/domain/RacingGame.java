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

    public RacingGame(String userNameAnswer, int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;

        String[] userNames = parseUserName(userNameAnswer);
        initRacingCar(userNames, carCount);
    }

    private static String[] parseUserName(String userNameAnswer) {
        final String NAME_SPLIT_DELIMITER = ",";
        return StringSpliter.getSplittedString(userNameAnswer, NAME_SPLIT_DELIMITER);
    }

    public boolean isProgress() {
        return this.getCurrentRound() < this.getGameCount();
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void doRacing() {
        cars.forEach(this::doGame);
        this.currentRound++;
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

    private void doGame(Car car) {
        int result = carMoveStrategy.getResult();
        car.move(result);
    }
}
