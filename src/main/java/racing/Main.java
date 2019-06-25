package racing;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = InputView.getCarsByNames();
        int racingCount = InputView.getRacingCount();
        for (; racingCount > 0; racingCount--) {
            cars.forEach(car -> car.move(CarCondition.get()));
            OutputView.showCarsProcess(cars);
        }

        OutputView.showWinner(cars);
    }
}
