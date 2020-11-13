package racing;

import racing.domain.Cars;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameApp {
    public static void main(String[] args) {
        Cars cars = Cars.from(InputView.inputNameOfCars());
        System.out.println("실행 결과");
        for (int i = 0, length = InputView.inputNumberOfRound(); i < length; i++) {
            cars.nextRound();
            ResultView.printCarNameAndPosition(cars);
            System.out.println();
        }
        ResultView.printVictoryCarNames(cars.getVictoryCarNames());
    }
}
