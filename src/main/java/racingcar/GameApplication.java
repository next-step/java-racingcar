package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceGame;
import racingcar.ui.InputView;
import racingcar.util.CarFactory;

import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int competitors = inputView.getCompetitors();
        int attemptCount = inputView.getAttemptCount();

        List<Car> cars = CarFactory.createCars(competitors);
        RaceGame raceGame = new RaceGame(attemptCount, cars);

        raceGame.startRace();
        raceGame.showGameResult();
    }
}
