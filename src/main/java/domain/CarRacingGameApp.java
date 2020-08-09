package domain;

import view.InputView;
import view.ResultView;

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
