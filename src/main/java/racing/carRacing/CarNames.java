package racing.carRacing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    public static String DELIMITER = ",";
    public static int CONDITION = 5;

    private final List<String> carNames;

    private CarNames(List<String> carNames) {
        overLengthCondition(carNames);
        hasSameCarName(carNames);

        this.carNames = carNames;
    }

    private void hasSameCarName(List<String> carNames) {
        Set<String> carSet = new HashSet<>(carNames);
        if (carNames.size() != carSet.size()) {
            throw new IllegalArgumentException("같은 자동차 이름이 있습니다.");
        }
    }

    private void overLengthCondition(List<String> carNames) {
        carNames.stream()
                .filter(this::isOverLength)
                .forEach(carName -> {
            throw new IllegalArgumentException("이름은 5자까지만 입력할 수 있습니다.");
        });
    }

    public static CarNames createCarNames(String carNames) {
        if (isNullOrEmpty(carNames) || isOnlyComma(carNames)) {
            throw new IllegalArgumentException("문자열을 입력해주세요");
        }
        return new CarNames(Arrays.asList(carNames.split(DELIMITER)));
    }

    private static boolean isOnlyComma(String carNames) {
        return carNames.equals(DELIMITER);
    }

    public int numberOfCars() {
        return carNames.size();
    }

    public Car matchCarName(int index) {
        return new Car(carNames.get(index));
    }

    private boolean isOverLength(String name) {
        return name.length() > CONDITION;
    }

    private static boolean isNullOrEmpty(String carNames) {
        return isNull(carNames) || isEmpty(carNames);
    }

    private static boolean isNull(String carNames) {
        return carNames == null;
    }

    private static boolean isEmpty(String carNames) {
        return carNames.isEmpty();
    }

}
