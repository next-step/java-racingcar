package racing;

import racing.model.CarCondition;
import racing.model.Cars;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Cars cars = InputView.getCarsByNames();
        int racingCount = InputView.getRacingCount();

        while (racingCount != 0) {
            cars.getCars().forEach(car -> car.move(CarCondition.get()));
            OutputView.showCarsProcess(cars);
            racingCount--;
        }
        OutputView.showWinner(cars);
    }
}
