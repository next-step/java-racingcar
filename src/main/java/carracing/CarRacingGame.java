package carracing;

import java.util.ArrayList;
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

    public List<List<String>> playGame() {
        List<List<String>> result = new ArrayList<>();
        result.add(saveInitialState());
        for (int i = 0; i < gameCount; ++i) {
            result.add(playOneRound());
        }
        return result;
    }

    private List<String> saveInitialState() {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getDistanceString());
        }
        return result;
    }
}
