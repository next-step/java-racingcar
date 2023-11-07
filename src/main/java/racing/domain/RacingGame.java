package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int carCount;
    private final int gameCount;
    private final CarMoveStrategy carMoveStrategy;
    private final List<Car> carList = new ArrayList<>();
    private int currentRound;

    public RacingGame(int carCount, int gameCount) {
        this(carCount, gameCount, new CarMoveStrategy(new Random()));
    }

    public RacingGame(int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.carCount = carCount;
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;
        initRacingCar(carCount);
    }

    public boolean isProgress() {
        return this.getCurrentRound() < this.getGameCount();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    private void initRacingCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getRacingCars() {
        return carList;
    }

    void doGame(Car car) {
        int result = carMoveStrategy.getResult();
        car.move(result);
    }

    public void doRacing() {
        carList.forEach(this::doGame);
        this.currentRound++;
    }
}
