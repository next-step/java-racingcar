package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        int numberOfCar = inputView.requestNumberOfCar();
        int time = inputView.requestTime();

        RacingGame racingGame = RacingGameFactory.newRacingGame(numberOfCar);
        startRacing(racingGame, time);
    }

    private void startRacing(RacingGame racingGame, int time) {
        outputView.printStart();
        for (int i = 0; i < time; i++) {
            racingGame.tryMove();
            outputView.printRound(racingGame.getPositions());
        }
    }

    public static void main(String[] args) {
        new RacingGameLauncher().play();
    }
}
