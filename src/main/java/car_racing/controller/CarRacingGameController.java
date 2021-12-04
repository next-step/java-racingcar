package car_racing.controller;

import car_racing.view.InputView;
import car_racing.model.MoveStrategy;
import car_racing.view.OutputView;
import car_racing.model.RandomMoveStrategy;
import car_racing.model.CarsForGame;

public class CarRacingGameController {

    private static final MoveStrategy MOVE_STRATEGY = new RandomMoveStrategy();
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    private CarsForGame carsForGame;
    private int numberOfRound;

    public void play() {
        initGame();

        for (int round = 0; round < numberOfRound; round++) {
            racingOneRound();
            showRacingResult(round);
        }

        showRacingWinners();
    }

    private void initGame() {
        String carNames = INPUT_VIEW.showMessageAndGetCarNames();
        int numberOfRoundInput = INPUT_VIEW.showMessageAndGetNumberOfRound();

        carsForGame = new CarsForGame(carNames);
        numberOfRound = numberOfRoundInput;
    }

    private void racingOneRound() {
        carsForGame.playOneRound(MOVE_STRATEGY);
    }

    private void showRacingResult(int round) {
        OUTPUT_VIEW.showCarRacingGameResult(carsForGame ,round);
    }

    private void showRacingWinners() {
        OUTPUT_VIEW.showWinners(carsForGame.findWinners());
    }
}
