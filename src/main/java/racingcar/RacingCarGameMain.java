package racingcar;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameMain {

    public static void main(String[] args) {
        String carNameText = InputView.askCarNames();
        RacingCars racingCars = RacingCars.of(carNameText);
        int numberOfTimes = InputView.askHowManyTimes();

        OutputView.printRacingResultTitle();

        for (int time = 0; time < numberOfTimes; time++) {
            racingCars.race();
            OutputView.printRacing(racingCars);
        }

        OutputView.printWinners(racingCars.pickWinners());
    }

}
