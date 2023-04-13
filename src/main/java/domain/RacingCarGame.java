package domain;

import io.ConsoleWriter;
import io.InputView;
import io.ResultView;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final ResultView resultView;
    public RacingCarGame(InputView inputView) {
        this.inputView = inputView;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputView.getCarCount(); i++) {
            cars.add(new Car());
        }
        this.resultView = new ResultView(cars);
    }

    public void startGame() {
        ConsoleWriter.writeHeader();
        for (int i = 0; i < inputView.getTryCount(); i++) {
            move();
            ConsoleWriter.write(resultView);
        }
    }
    private void move() {
        for (Car car : resultView.getCars()) {
            car.move(RandomGenerator.getCarRandomInt(10));
        }
    }
}
