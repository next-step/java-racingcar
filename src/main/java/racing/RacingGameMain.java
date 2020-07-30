package racing;

import racing.model.Cars;
import racing.model.RacingGame;
import racing.model.RandomValueGenerator;
import racing.view.RacingInputView;
import racing.view.RacingResultView;

import java.util.List;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingInputView racingInputView = new RacingInputView();
        String inputNamesOfCar = racingInputView.inputNameOfCar();

        Cars racingCars = new Cars();
        racingCars.createCars(inputNamesOfCar);

        int time = racingInputView.inputCountOfTry();
        racingInputView.close();

        List<Integer> randomValues;

        RacingGame racingGame = new RacingGame(racingCars, time);
        RacingResultView racingResultView = new RacingResultView();
        while (racingGame.hasTime()) {
            randomValues = RandomValueGenerator.getRandomValues(racingCars.countOfCars());
            racingGame.race(randomValues);
            racingResultView.printRace(racingGame.getCars());
        }
        racingResultView.printWinners(racingGame.getCars());
    }

}
