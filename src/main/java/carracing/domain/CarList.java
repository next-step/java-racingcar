package carracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    public static final int NAME_LENGTH_UPPER_BOUND = 5;
    public static final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public CarList(String carNameString) {
        List<String> names = validateStringArray(carNameString);
        for (String name : names) {
            cars.add(new Car(name));
        }
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

    public List<String> playOneRound(NumberGenerator randomNumberGenerator) {
        List<String> result = new ArrayList<>();
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateNumber());
            result.add(car.makeDistanceString());
        }
        return result;
    }

    public List<Car> findWinners() {
        int maxDistance = maxCarDistance();
        return cars.stream()
                .filter(c -> c.hasSameDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int maxCarDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.returnMaxDistance(maxDistance);
        }
        return maxDistance;
    }
}
