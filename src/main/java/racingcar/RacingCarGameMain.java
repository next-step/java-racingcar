package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameMain {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String carNameText = InputView.askCarNames();
        int numberOfTimes = InputView.askHowManyTimes();

        racingCarGame.start(carNameText, numberOfTimes);

        OutputView.printRacingResultTitle();
        racingCarGame.play();
    }
    
}
