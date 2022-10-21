package nextstep.javaracingcar.controller;

import nextstep.javaracingcar.domain.CarRacingGame;
import nextstep.javaracingcar.domain.CarRacingGameInput;
import nextstep.javaracingcar.domain.MovingStrategy;
import nextstep.javaracingcar.domain.RandomGoOrStop;
import nextstep.javaracingcar.view.InputView;
import nextstep.javaracingcar.view.ResultView;

import java.util.Random;

public class CarRacingGameController {
    public void race(final InputView inputView, final ResultView resultView) {

        final Random random = new Random();
        final MovingStrategy goOrStopEngine = new RandomGoOrStop(() -> random.nextInt(10), 4);

        final CarRacingGameInput input = inputView.input();
        final CarRacingGame carRacingGame = new CarRacingGame(input.getCarNames(), input.round(), goOrStopEngine);

        resultView.printResultTitle();

        while (carRacingGame.hasNextRound()) {
            resultView.printResult(carRacingGame.runRound());
        }

        resultView.printWinners(carRacingGame.result());
    }
}
