package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.racinggame.RacingGame;
import racingcar.view.RacingCarView;

public class RacingGameController {

    private final RacingCarView view;

    public RacingGameController(final RacingCarView view) {
        this.view = view;
    }

    public void playGame(final String carNames, final String count) {

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);
        racingGame.play();

        printResult(racingGame);
    }

    private void printResult(final RacingGame racingGame) {
        view.printResults(racingGame.getTotalResult());
        view.printResult(racingGame.getResults());
        view.printWinners(racingGame.getWinners());
    }

    public String readCarNames() {
        view.printCarNamesPrompt();
        return view.read();
    }

    public String readCount() {
        view.printCountPrompt();
        return view.read();
    }
}
