package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();
        int numberOfCars = inputView.getNumberOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();
        Racing racing = Racing.withCondition(numberOfCars, numberOfTurns);
        printView.printResultTitle();
        printView.printCarStatus(racing.getCars());

        while (!racing.hasRaceEnd()) {
            racing.race();
            printView.printCarStatus(racing.getCars());
        }
    }
}
