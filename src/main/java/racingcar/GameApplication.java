package racingcar;

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
