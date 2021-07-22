package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import racingcar.common.InputMessage;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private final Random random = new Random();

    private final int carCount;
    private final int driveCount;

    private final List<Car> cars = new ArrayList<>();

    public Game() {
        carCount = inputView.inputInteger(InputMessage.CAR_COUNT);
        driveCount = inputView.inputInteger(InputMessage.DRIVE_COUNT);

        IntStream.range(0, carCount).forEach(i -> cars.add(new Car()));
    }

    public Game(int carCount, int driveCount) {
        this.carCount = carCount;
        this.driveCount = driveCount;

        IntStream.range(0, carCount).forEach(i -> cars.add(new Car()));
    }

    public void doGame() {
        for (int i = 0; i < driveCount; i++) {
            doDrive(cars);
            resultView.pirntProgressBoard(cars);
        }
    }

    private void doDrive(List<Car> cars) {
        cars.forEach(car -> car.drive(random.nextInt(10)));
    }
}
