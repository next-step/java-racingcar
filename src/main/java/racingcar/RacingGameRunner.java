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

    private void printResult(RacingGame racingGame) {
        view.printResults(racingGame.getEachResults());
        view.printResult(racingGame.getResult());
        view.printWinners(racingGame.getWinners());
    }

    private String getCount() {
        view.printCountPrompt();
        String count = view.read();
        return count;
    }

    private String getCarNames() {
        view.printCarNamesPrompt();
        String carNames = view.read();
        return carNames;
    }

}
