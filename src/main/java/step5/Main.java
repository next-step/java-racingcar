package step5;

import java.util.List;
import step5.domain.RacingCar;
import step5.domain.RacingGame;
import step5.domain.RandomMovingStrategy;
import step5.view.InputView;
import step5.view.OutputView;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.create();
        String carName = inputView.getCarName();
        int time = inputView.getTime();

        RacingGame racingGame = RacingGame.create(new RandomMovingStrategy());
        racingGame.readyRacingCars(carName);

        OutputView.printResult();
        for (int i = 0; i < time; i++) {
            List<RacingCar> racingCars = racingGame.startRacing();
            OutputView.printRacingCars(racingCars);
        }

        OutputView.printRacingGameWinner(racingGame.getWinners());
    }
}
