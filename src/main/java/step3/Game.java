package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private static final String NAME_DELIMITER = ",";

    public GameResults play(String nameInput, int gameCount) {
        Cars cars = new Cars(makeRacingCars(nameInput));
        return new GameResults(playAndSaveGameResults(gameCount, cars));
    }

    private List<RoundResult> playAndSaveGameResults(int gameCount, Cars cars) {
        List<RoundResult> gameResults = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            cars.moveCarsByStrategy();
            gameResults.add(new RoundResult(cars.showCarsPositions()));
        }
        return gameResults;
    }

    private List<Car> makeRacingCars(String nameInput) {
        String[] names = nameInput.split(NAME_DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
