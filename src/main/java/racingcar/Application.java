package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int competitors = inputView.getCompetitors();
        int attemptCount = inputView.getAttemptCount();

        List<Car> cars = createCars(competitors);
        RaceGame raceGame = new RaceGame(attemptCount, cars);

        raceGame.startRace();
    }

    public static List<Car> createCars(int competitors) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < competitors; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
