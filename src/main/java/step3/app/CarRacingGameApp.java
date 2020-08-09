package step3.app;

import step3.domain.CarRacingGame;
import step3.input.InputView;
import step3.output.ResultView;

public class CarRacingGameApp {

    public static void main(String[] args) {
        String csvNameLineOfCars = InputView.getCsvNameLineOfCars();
        String[] names = csvNameLineOfCars.split(",");
        int numberOfAttempts = InputView.getNumberOfAttempts();
        CarRacingGame carRacingGame = new CarRacingGame(names, numberOfAttempts);
        carRacingGame.start();
        ResultView resultView = new ResultView(carRacingGame.getRapResults());
        resultView.printResult();
    }

}
