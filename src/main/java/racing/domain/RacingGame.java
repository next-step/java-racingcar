package racing.domain;

import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final int carCount;
    private final int gameCount;
    private final CarMoveStrategy carMoveStrategy;
    private final List<Car> carList = new ArrayList<>();

    public RacingGame(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
        this.carMoveStrategy = new CarMoveStrategy(new Random());
        initRacingCar(carCount);
    }

    public RacingGame(int carCount, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.carCount = carCount;
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        initRacingCar(carCount);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    private void initRacingCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getRacingCar() {
        return carList;
    }

    public void doGame(Car car) {
        int result = carMoveStrategy.getResult();
        car.move(result);
        ResultView.getProgress(car.getPosition());
    }

    public void doRacing() {
        for (int i = 0; i < gameCount; i++) {
            carList.forEach(this::doGame);
        }
    }
}
