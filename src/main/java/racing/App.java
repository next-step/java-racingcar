package racing;

import racing.domain.RacingGame;
import racing.domain.RacingRanking;
import racing.ui.RacingInputView;
import racing.ui.RacingResultView;

public class App {
    public static void main(String[] args) {
        String[] carNames = RacingInputView.inputTryNames(Messages.INPUT_CARNAMES);
        int times = RacingInputView.inputTryNo(Messages.INPUT_TRYTIMES);

        RacingGame racingGame = new RacingGame(times, carNames);
        
        while (!racingGame.isFinish()) {
            racingGame.move();
            RacingResultView.renderGameProgress(racingGame.getResultOfTheGame());
        }

        RacingRanking racingRanking = new RacingRanking(racingGame.getResultOfTheGame());
        RacingResultView.renderWinner(racingRanking.getWinners());
    }
}
