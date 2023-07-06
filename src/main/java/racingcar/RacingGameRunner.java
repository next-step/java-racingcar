package racingcar;

import racingcar.car.Cars;
import racingcar.view.RacingCarView;

public class RacingGameRunner {

    private final RacingCarView view;

    public RacingGameRunner(RacingCarView view) {
        this.view = view;
    }

    public void run() {
        String carNames = getCarNames();
        String count = getCount();

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);
        racingGame.play();

        printResult(racingGame);
    }

    private String getCarNames() {
        view.printCarNamesPrompt();
        return view.read();
    }

    private String getCount() {
        view.printCountPrompt();
        return view.read();
    }

    private void printResult(RacingGame racingGame) {
        view.printResults(racingGame.getEachResults());
        view.printResult(racingGame.getResult());
        view.printWinners(racingGame.getWinners());
    }
}
