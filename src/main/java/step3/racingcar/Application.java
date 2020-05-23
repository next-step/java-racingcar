package step3.racingcar;

import step3.racingcar.domain.Message;
import step3.racingcar.domain.RacingGame;
import step3.racingcar.view.InputViewProcessor;
import step3.racingcar.view.ResultViewProcessor;

public class Application {

    public static void main(String[] args) {
        String[] carNames = InputViewProcessor.getCarNames(Message.CAR_NAMES);
        int gameTryCounts = InputViewProcessor.getGameTryCounts(Message.GAME_TRY_COUNTS);

        RacingGame racingGame = new RacingGame(carNames, gameTryCounts);
        racingGame.run();

        ResultViewProcessor.printResultHeader(Message.RESULT_HEADER);
        //ResultViewProcessor.printWinnerCarNames(playerCars);
    }
}
