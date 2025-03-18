package carracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    public static final int NAME_LENGTH_UPPER_BOUND = 5;
    public static final String DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator randomNumberGenerator;
    private final int gameCount;

    public CarRacingGame(String carNameString, int gameCount, NumberGenerator numberGenerator) {
        List<String> names = validateStringArray(carNameString);
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.gameCount = validateGameCount(gameCount);
        randomNumberGenerator = numberGenerator;
    }

    private int validateGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 0보다 커야 합니다.");
        }
        return gameCount;
    }

    private List<String> validateStringArray(String carNameString) {
        String[] names = carNameString.split(DELIMITER);
        for (String name : names) {
            checkValidateName(name);
        }
        return Arrays.asList(names);
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
            winners.add(returnNameIfMax(car, maxDistance));
        }
        winners.removeAll(Collections.singletonList(null));
        return winners;
    }

    private String returnNameIfMax(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            return car.getName();
        }
        return null;
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
