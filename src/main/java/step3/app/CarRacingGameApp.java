package step3.app;

import step3.input.InputView;
import step3.output.ResultView;
import step3.service.CarRacingGame;

public class CarRacingGameApp {

    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int numberOfAttempts = InputView.getNumberOfAttempts();
        CarRacingGame carRacingGame = new CarRacingGame(numberOfCars, numberOfAttempts);
        carRacingGame.start();
        ResultView.printResult(carRacingGame.getScoreboard());
    }

}
