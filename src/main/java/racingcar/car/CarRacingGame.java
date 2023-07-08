package racingcar.car;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.RandomMoveStrategy;
import racingcar.car.view.InputView;
import racingcar.car.view.OutputView;

public class CarRacingGame {

    private final Cars cars;


    public CarRacingGame() {
        cars = new Cars(InputView.getCarNames());
    }

    public void play() {
        startRace(InputView.getPlayCount());
        printWinners();
    }

    private void startRace(final int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            cars.move(new RandomMoveStrategy());
            sb.append(OutputView.formatCars(cars.getCars()));
        }
        OutputView.printResult(sb.toString());
    }

    private void printWinners() {
        List<Car> winners = cars.getWinners();
        OutputView.printWinners(winners);
    }
}
