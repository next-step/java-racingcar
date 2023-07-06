package racingcar;

import racingcar.car.Cars;
import racingcar.view.RacingCarView;

public class RacingGameRunner {

    private final RacingCarView view;

    public RacingGameRunner(RacingCarView view) {
        this.view = view;
    }

    public void run() {
        view.printCarNamesPrompt();
        String carNames = view.read();

        view.printCountPrompt();
        String count = view.read();

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);
        racingGame.play();

        view.printResults(racingGame.getEachResults());
        view.printResult(racingGame.getResult());
        view.printWinners(racingGame.getWinners());
    }
}
