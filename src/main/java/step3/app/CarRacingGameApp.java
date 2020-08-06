package step3.app;

import step3.domain.CarRacingGame;
import step3.input.InputView;
import step3.output.ResultView;

import java.util.Arrays;

public class CarRacingGameApp {

    public static void main(String[] args) {
        String csvNameLineOfCars = InputView.getCsvNameLineOfCars();
        String[] names = splitAndValidateCsvNameLineOfCars(csvNameLineOfCars);
        int numberOfAttempts = InputView.getNumberOfAttempts();
        CarRacingGame carRacingGame = new CarRacingGame(names, numberOfAttempts);
        carRacingGame.start();
        ResultView resultView = new ResultView(carRacingGame.getRapResults());
        resultView.printResult();
    }

    public static String[] splitAndValidateCsvNameLineOfCars(String csvNameLineOfCars) {
        String[] names = csvNameLineOfCars.split(",");
        Arrays.stream(names)
                .filter(name -> name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException();
                });
        return names;
    }

}
