package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.console.RacingGameInput;
import racingcar.view.console.RacingGameOutput;

public class ConsoleMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] carNames = RacingGameInput.takeCarNames();
        int numberOfTimes = RacingGameInput.takeNumberOfTimes();

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < numberOfTimes; i++) {
            RacingGameOutput.showRaceOf(racingGame.play());
        }

        RacingGameOutput.showWinners(racingGame.getWinners());
    }

}
