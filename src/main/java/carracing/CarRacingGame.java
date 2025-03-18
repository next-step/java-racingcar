package carracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    public static final int NAME_LENGTH_UPPER_BOUND = 5;
    public static final String DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator randomNumberGenerator;
    private int gameCount;

    public CarRacingGame(String carNameString, int _gameCount, NumberGenerator numberGenerator) {
        String[] names = validateStringArray(carNameString);
        for (String name : names) {
            cars.add(new Car(name));
        }
        gameCount = validateGameCount(_gameCount);
        randomNumberGenerator = numberGenerator;
    }

    private int validateGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 0보다 커야 합니다.");
        }
        return gameCount;
    }

    private String[] validateStringArray(String carNameString) {
        String[] names = carNameString.split(DELIMITER);
        for (String name : names) {
            checkValidateName(name);
        }
        return names;
    }

    private static void checkValidateName(String name) {
        if (name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException("자동차의 이름은 " + NAME_LENGTH_UPPER_BOUND + "를 초과할 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름이 없습니다.");
        }
    }

    public List<String> playOneRound() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateNumber());
            result.add(car.getDistanceString());
        }
        return result;
    }

    public GameResult playGame() {
        List<List<String>> result = new ArrayList<>();
        result.add(saveInitialState());
        for (int i = 0; i < gameCount; ++i) {
            result.add(playOneRound());
        }
        List<String> winners = decideWinners();
        return new GameResult(result, winners);
    }

    private List<String> decideWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = maxCarDistance();
        for (Car car : cars) {
            updateWinners(car, maxDistance, winners);
        }
        return winners;
    }

    private void updateWinners(Car car, int maxDistance, List<String> winners) {
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }

    private int maxCarDistance() {
        List<Integer> distances = new ArrayList<>();
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
        return Collections.max(distances);
    }

    private List<String> saveInitialState() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getDistanceString());
        }
        return result;
    }
}
