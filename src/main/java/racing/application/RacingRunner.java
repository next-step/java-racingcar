package racing.application;

import racing.Messages;
import racing.domain.RacingGame;
import racing.domain.RacingRanking;
import racing.ui.RacingInputView;
import racing.ui.RacingResultView;

public class RacingRunner {

    public void run() {
        String[] carNames = RacingInputView.inputTryNames(Messages.INPUT_CARNAMES);
        int times = RacingInputView.inputTryNo(Messages.INPUT_TRYTIMES);

        RacingGame racingGame = new RacingGame(times, carNames);

        while (!racingGame.isFinish()) {
            racingGame.move();
            RacingResultView.renderGameProgress(racingGame.getResultOfTheGame());
        }

        RacingRanking racingRanking = new RacingRanking(racingGame);
        RacingResultView.renderWinner(racingRanking.getWinners());
    }

}
