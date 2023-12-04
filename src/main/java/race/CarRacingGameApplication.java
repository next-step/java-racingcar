package race;

import race.domain.CarRacingGame;
import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;

public class CarRacingGameApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames().split(",");
        int numberOfTry = InputView.inputNumberOfTry();
        Cars cars = new Cars(carNames);

        CarRacingGame carRacingGame = new CarRacingGame(cars);

        for(int i=0; i < numberOfTry; i++){
            carRacingGame.play();
        }

        ResultView.printResult(cars);
    }
}
