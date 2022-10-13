package nextstep.javaracingcar;

import nextstep.javaracingcar.view.InputView;
import nextstep.javaracingcar.view.ResultView;

import java.util.Random;

public class CarRacingGameConsoleLauncher {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRacingGameConsoleLauncher(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {

        final Random random = new Random();
        final MovingStrategy goOrStopEngine = new RandomGoOrStop(() -> random.nextInt(10), 4);

        final CarRacingGameInput input = inputView.input();
        final CarRacingGame carRacingGame = new CarRacingGame(input.getCarNames(), input.round(), goOrStopEngine);

        resultView.printResultTitle();

        while (carRacingGame.hasNextRound()) {
            resultView.printResult(carRacingGame.runRound());
        }
    }
}
