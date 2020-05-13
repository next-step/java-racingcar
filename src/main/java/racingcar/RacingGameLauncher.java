package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        List<String> carNames = inputView.requestCarNames();
        int time = inputView.requestTime();

        RacingGame racingGame = RacingGameFactory.newRacingGame(carNames);
        startRacing(racingGame, time);
    }

    private void startRacing(RacingGame racingGame, int time) {
        outputView.printStart();
        for (int i = 0; i < time; i++) {
            racingGame.tryMove();
            outputView.printRound(racingGame.getCars());
        }
        outputView.printEnd(racingGame.getWinners());
    }

    public static void main(String[] args) {
        new RacingGameLauncher().play();
    }
}
