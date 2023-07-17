package study.step3;

import study.step3.domain.Cars;
import study.step3.view.InputView;
import study.step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        final int numberOfCars = InputView.numberOfCars();
        final int repeatCount = InputView.repeatCount();

        final Cars cars = new Cars(numberOfCars);

        for (int i = 0; i < repeatCount; i++) {
            cars.race();
            ResultView.printOutPositions(cars);
        }
    }
}
