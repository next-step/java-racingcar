package step3;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public GameResults play(int carCount, int gameCount) {

        Cars cars = new Cars(makeRacingCars(carCount));

        return new GameResults(playAndSaveGameResults(gameCount, cars));
    }

    private List<RoundResult> playAndSaveGameResults(int gameCount, Cars cars) {
        List<RoundResult> gameResults = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            cars.moveCarsByStrategy();
            gameResults.add(new RoundResult(cars.showCarsDistances()));
        }
        return gameResults;
    }

    private List<Car> makeRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
