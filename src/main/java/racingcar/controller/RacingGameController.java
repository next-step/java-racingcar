package racingcar.controller;

import racingcar.domain.Car.Cars;
import racingcar.racinggame.RacingGame;
import racingcar.view.RacingCarView;

public class RacingGameController {

    private final RacingCarView view;

    public RacingGameController(RacingCarView view) {
        this.view = view;
    }

    public void playGame(String carNames, String count) {

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);
        racingGame.play();

        printResult(racingGame);
    }

    private void printResult(RacingGame racingGame) {
        view.printResults(racingGame.getEachResults());
        view.printResult(racingGame.getResult());
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
