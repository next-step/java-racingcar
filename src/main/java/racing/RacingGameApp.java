package racing;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApp {
    public static void main(String[] args) {
        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfRound = InputView.inputNumberOfRound();

        Cars cars = Cars.from(numberOfCars);

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRound; i++) {
            cars.nextRound();
            ResultView.printCarPosition(cars);
            System.out.println();
        }
    }
}
