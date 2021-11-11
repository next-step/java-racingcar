package racinggame;

import racinggame.domain.CarStateGenerator;
import racinggame.domain.Laps;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;

public class RacingGameMain {

    public static void main(String[] args) {
        CarStateGenerator carStateGenerator = new CarStateGenerator();
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        Laps laps = inputView.inputLaps();

        RacingGame racingGame = new RacingGame(carCount, laps, carStateGenerator);
        racingGame.startRacing();
    }
}
