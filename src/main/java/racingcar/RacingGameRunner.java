package racingcar;

import racingcar.car.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {

        String[] racers = InputView.inputRacers();
        int time = InputView.inputTime();

        RacingGame racingGame = new RacingGame(racers, time);
        List<Car> cars = racingGame.game();

        OutputView.showWinner(cars);
    }
}
