package racingcar;

import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.model.RacingGame;

public class RacingCarApplication {

    private static RacingGame racingGame;

    public static void main(String[] args) {
        OutputView.start();
        int carCount = InputView.askCarCount();
        int time = InputView.askTime();
        racingGame = RacingGame.generate(time, carCount);

        OutputView.ready(racingGame.getResult());
        while (!racingGame.isGameOver()){
            OutputView.playResult(racingGame.racing());
        }
        OutputView.end();
    }
}
