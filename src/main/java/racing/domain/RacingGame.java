package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int gameCount;
    private final CarMoveStrategy carMoveStrategy;
    private final List<Car> cars = new ArrayList<>();
    private int currentRound;

    public RacingGame(String[] userNames, int gameCount, CarMoveStrategy carMoveStrategy) {
        this.gameCount = gameCount;
        this.carMoveStrategy = carMoveStrategy;
        this.currentRound = 0;

        initRacingCar(userNames);
    }

    private void initRacingCar(String[] userNames) {
        for (int i = 0; i < userNames.length; i++) {
            cars.add(new Car(userNames[i]));
        }
    }


    public boolean isProgress() {
        return this.getCurrentRound() < this.getGameCount();
    }


    public void race() {
        cars.forEach(this::playGame);
        this.currentRound++;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winCars = new ArrayList<>();

        List<Car> racingCars = getRacingCars();
        racingCars.stream()
                .filter(o -> o.isFartherOrEqual(maxPosition))
                .forEach(winCars::add);
        return winCars;
    }

    private void playGame(Car car) {
        int result = carMoveStrategy.getMoveSource();
        car.move(result);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        List<Car> racingCars = getRacingCars();
        for (Car racingCar : racingCars) {
            if (racingCar.isFartherOrEqual(maxPosition)) {
                maxPosition = racingCar.getPosition().getValue();
            }
        }
        return maxPosition;
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

}
