package study.racinggame;

import study.racinggame.domain.Cars;
import study.racinggame.view.InputView;
import study.racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        final int numberOfCars = InputView.numberOfCars();
        final int repeatCount = InputView.repeatCount();

        final Cars cars = new Cars(numberOfCars, repeatCount);

        while (!cars.isEndGame()) {
            cars.race();
            ResultView.printOutPositions(cars);
        }
    }
}
