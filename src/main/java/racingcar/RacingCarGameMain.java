package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameMain {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String carNameText = InputView.askCarNames();
        int numberOfTimes = InputView.askHowManyTimes();

        OutputView.printRacingResultTitle();
        RacingCars result = racingCarGame.play(new RacingCars(carNameText), numberOfTimes);
        OutputView.printWinners(racingCarGame.pickWinners(result));
    }

}
