package racingcar;

import java.util.Arrays;
import racingcar.vehicle.CarFactory;
import racingcar.vehicle.Cars;
import racingcar.view.ResultView;

public class Game {

    private final int driveCount;

    private final Cars cars = new Cars();

    public Game(String carNames, int driveCount) {
        Arrays.stream(carNames.split(","))
            .forEach(carName -> cars.add(CarFactory.create("test")));
        this.driveCount = driveCount;
    }

    public void doGame() {
        for (int i = 0; i < driveCount; i++) {
            cars.doDrive();
            ResultView.pirntProgressBoard(cars);
        }
    }
}
