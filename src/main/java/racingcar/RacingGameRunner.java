package racingcar;

import racingcar.car.Car;
import racingcar.car.CarRegistration;
import racingcar.race.RacingGame;
import racingcar.race.Ranking;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {

        String[] racers = InputView.inputRacers();
        int time = InputView.inputTime();

        CarRegistration carRegistration = new CarRegistration();
        List<Car> cars = carRegistration.register(racers);

        RacingGame racingGame = new RacingGame(time);
        int topPosition = racingGame.game(cars);

        Ranking ranking = new Ranking(topPosition, cars);
        int winner = ranking.countWinner(cars);
        OutputView.showWinner(cars, winner);
    }
}
