package nextstep.javaracingcar;

import nextstep.javaracingcar.view.InputSupplier;
import nextstep.javaracingcar.view.InputView;
import nextstep.javaracingcar.view.OutputConsumer;
import nextstep.javaracingcar.view.ResultView;

import java.util.List;
import java.util.Random;

import static nextstep.javaracingcar.PositiveNumber.from;

public class CarRacingGameConsoleLauncher {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRacingGameConsoleLauncher(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {

        final Random random = new Random();
        final CarEngine goOrStopEngine = new GoOrStopEngine(() -> random.nextInt(10), 4);

        final CarRacingGameInput input = inputView.input();
        final CarRacingGame carRacingGame = new CarRacingGame(input.carCount(), input.round(), goOrStopEngine);

        resultView.printReusltTitle();

        while (carRacingGame.hasNextRound()) {
            resultView.printResult(carRacingGame.runRound());
        }
    }
}
