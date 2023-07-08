package racingcar.car;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.RandomMoveStrategy;

public class CarRacingGame {

    private final Cars cars;
    private final int playCount;

    public CarRacingGame(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
    }

    public void play() {
        startRace();
    }

    public boolean isRunning() {
        return playCount > 0;
    }

    public List<Car> getMiddleState() {
        return cars.getCars();
    }

    public List<Car> getResult() {
        return cars.getWinners();
    }

    private void startRace() {
        cars.move(new RandomMoveStrategy());
    }
}
