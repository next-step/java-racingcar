package racingcar;

import racingcar.car.Car;
import racingcar.car.CarRegistration;
import racingcar.race.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {

        String[] racers = InputView.inputRacers();
        int time = InputView.inputTime();

        List<Car> cars = CarRegistration.register(racers);

        RacingGame racingGame = new RacingGame(time);
        cars = racingGame.game(cars);

        OutputView.showWinner(cars);
    }
}
