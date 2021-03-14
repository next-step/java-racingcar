package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();

        String[] namesOfCars = inputView.getNamesOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();

        Racing racing = Racing.withCondition(namesOfCars, numberOfTurns);
        printView.printResultTitle();
        printView.printCarStatus(racing.getCars());

        while (!racing.hasRaceEnd()) {
            racing.race();
            printView.printCarStatus(racing.getCars());
        }
        printView.printWinners(racing.getWinners());
    }
}
