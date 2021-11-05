package racingcar;

import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int countOfCar = inputView.inputCountOfCar();
        int countOfTry = inputView.inputCountOfTry();

        RacingGame game = new RacingGame(countOfCar);

        outputView.printExecutionResultMessage();
        for (int i = 0; i < countOfTry; i++) {
            List<Integer> currentPositions = game.race();
            outputView.printCurrentPositionOfCars(currentPositions);
        }
    }
}
