package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator randomNumberGenerator;

    public CarRacingGame(String carNameString, NumberGenerator numberGenerator) {
        String[] names = validateStringArray(carNameString);
        for (String name : names) {
            cars.add(new Car(name));
        }
        randomNumberGenerator = numberGenerator;
    }

    private String[] validateStringArray(String carNameString) {
        String[] names = carNameString.split(",");
        for (String name : names) {
            checkValidateName(name);
        }
        return names;
    }

    private static void checkValidateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5를 초과할 수 없습니다.");
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

    public List<List<String>> playGame(int gameCount) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < gameCount; ++i) {
            result.add(playOneRound());
        }
        return result;
    }
}
