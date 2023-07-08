package racingcar.car;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.view.InputView;
import racingcar.car.view.OutputView;

public class CarRacingGame {

    private final Cars cars;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public CarRacingGame() {
        cars = new Cars(inputView.getCarNames());
    }

    public void play() {
        startRace(inputView.getPlayCount());
        printWinners();
    }

    private void startRace(final int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            cars.move();
            sb.append(outputView.formatCars(cars.getCars()));
        }
        outputView.printResult(sb.toString());
    }

    private void printWinners() {
        List<Car> winners = cars.getWinners();
        outputView.printWinners(winners);
    }
}
