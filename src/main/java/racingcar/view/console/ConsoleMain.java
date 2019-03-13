package racingcar.view.console;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRegistration;
import racingcar.domain.race.RacingGame;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {

        String[] racers = InputView.inputRacers();
        int time = InputView.inputTime();

        List<Car> cars = CarRegistration.register(racers);

        RacingGame racingGame = new RacingGame(time);
        cars = racingGame.game(cars);


        OutputView.showWinner(cars);
    }
}
