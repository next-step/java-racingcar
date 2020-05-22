package step3.racingcar;

import step3.racingcar.controller.RacingGame;
import step3.racingcar.domain.Message;
import step3.racingcar.view.InputViewProcessor;

public class Application {

    public static void main(String[] args) {
        String[] carNames = InputViewProcessor.getCarNames(Message.CAR_NAMES);
        int gameTryCounts = InputViewProcessor.getGameTryCounts(Message.GAME_TRY_COUNTS);

        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);
        racingGame.run();
    }
}
