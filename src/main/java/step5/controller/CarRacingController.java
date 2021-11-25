package step5.controller;

import step5.domain.CarRacingGame;
import step5.domain.Cars;
import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.cargameStrategy.RandomCarRacingGameStrategy;
import step5.view.InputView;
import step5.view.OutputView;

public class CarRacingController {

    private static final CarRacingGameStrategy carRacingGameStrategy = new RandomCarRacingGameStrategy();

    public CarRacingGame createGame() {
        int numberOfAttempts = InputView.inputAttemptNumber();
        String inputCarNames = InputView.inputCarNames();
        Cars cars = Cars.from(inputCarNames);
        return new CarRacingGame(carRacingGameStrategy, cars, numberOfAttempts);
    }

    public void play(CarRacingGame carRacingGame){
        carRacingGame.play();
    }

    public void drawResult(CarRacingGame carRacingGame){
        OutputView.printResult();
        OutputView.printHistory(carRacingGame.getGameHistory());
        OutputView.printWinner(carRacingGame.winners());

    }

}
