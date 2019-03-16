package racingcar.view.console;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRegistration;
import racingcar.domain.race.RacingGame;
import racingcar.domain.race.Ranking;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {

        String[] racers = InputView.inputRacers();
        int turn = InputView.inputTime();

        List<Car> cars = CarRegistration.register(racers);

        RacingGame racingGame = new RacingGame(turn);
        racingGame.game(cars);

        OutputView.showStatus(cars, turn);

        Ranking ranking = new Ranking();
        OutputView.showWinner(ranking.findWinner(cars));
    }
}
