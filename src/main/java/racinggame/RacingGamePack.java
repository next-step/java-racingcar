package racinggame;

import racinggame.domain.Cars;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGamePack {

    private Cars cars;

    public void startGame() {
        initializeGame();
        cars.raceStart();
        ResultView.display(cars);
    }

    private void initializeGame() {
        int carCount = InputView.inputCarsCount();
        int raceCount = InputView.inputRaceCount();
        cars = new Cars(carCount, raceCount);
    }


}
