package racingcar.step3;

import racingcar.step3.move.RandomMoveStrategy;
import racingcar.step3.print.DashVisualizePrintStrategy;

public class RacingCar {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carsNumber = inputView.getCarsNumbersInput();
        int roundsNumber = inputView.getRoundsNumberInput();

        RacingCarContest racingCarContest = new RacingCarContest(
                carsNumber, roundsNumber, new RandomMoveStrategy(), new DashVisualizePrintStrategy()
        );

        racingCarContest.startRacingContest();
    }
}
