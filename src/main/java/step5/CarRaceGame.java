package step5;

import step5.domain.Cars;
import step5.util.MoveStrategy;
import step5.util.RandomMoveStrategy;
import step5.view.InputView;
import step5.view.ResultView;

public class CarRaceGame {
    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        String names = InputView.inputCarNames();
        Cars cars = new Cars(names);

        int tryNumber = InputView.inputTryNumber();
        for (int i = 0; i < tryNumber; i++) {
            cars.move(moveStrategy);
            ResultView.printLocations(cars.getAllCars());
        }

        ResultView.printWinner(cars.getWinners());
    }
}
