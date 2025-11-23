package racinggame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarFactory {
    private static final int MAX_NAME_LENGTH = 5;

    public static List<Car> createCars(String names) {
        List<String> carNames = parseNames(names);
        validateDuplicateNames(carNames);
        return convertToCars(carNames);
    }

    private static List<String> parseNames(String names) {
        String[] split = names.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : split) {
            carNames.add(name.trim());
        }

        return carNames;
    }

    private static void validateDuplicateNames(List<String> carNames) {
        Set<String> duplicateNames = new HashSet<>(carNames);

        if (duplicateNames.size() < carNames.size()) {
            throw new IllegalArgumentException("각 자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static List<Car> convertToCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
