package racing;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Car> cars = InputView.getCarsByNames();
        int racingCount = InputView.getRacingCount();

        while (racingCount != 0) {
            cars.forEach(car -> car.move(CarCondition.get()));
            OutputView.showCarsProcess(cars);
            racingCount--;
        }
        OutputView.showWinner(cars);
    }
}
