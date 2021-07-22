package racingcar;

import java.util.stream.IntStream;
import racingcar.common.InputMessage;
import racingcar.vehicle.CarFactory;
import racingcar.vehicle.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private final int carCount;
    private final int driveCount;

    private final Cars cars = new Cars();

    public Game() {
        carCount = inputView.inputInteger(InputMessage.CAR_COUNT);
        driveCount = inputView.inputInteger(InputMessage.DRIVE_COUNT);

        IntStream.range(0, carCount).forEach(i -> cars.add(CarFactory.create()));
    }

    public Game(int carCount, int driveCount) {
        this.carCount = carCount;
        this.driveCount = driveCount;

        IntStream.range(0, carCount).forEach(i -> cars.add(CarFactory.create()));
    }

    public void doGame() {
        for (int i = 0; i < driveCount; i++) {
            cars.doDrive();
            resultView.pirntProgressBoard(cars);
        }
    }
}
