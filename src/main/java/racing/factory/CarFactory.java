package racing.factory;

import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class CarFactory {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private static class CarFactoryHandler {
        private static final CarFactory INSTANCE = new CarFactory();
    }

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public List<Car> manufactureCars(final List<String> carNames) {
        if (isInvalid(carNames)) {
            throw new IllegalArgumentException("잘못된 형식의 자동차 이름입니다.");
        }

        return carNames.stream()
                       .map(Car::new)
                       .collect(Collectors.toUnmodifiableList());
    }

    private boolean isInvalid(final List<String> carNames) {
        return containsLongName(carNames) || isDuplicated(carNames) || containsBlank(carNames);
    }

    private static boolean containsLongName(final List<String> carNames) {
        return carNames.stream()
                       .anyMatch(carName -> carName.length() > MAX_CAR_NAME_LENGTH);
    }

    private static boolean isDuplicated(final List<String> carNames) {
        final long distinctCount = carNames.stream()
                                           .distinct()
                                           .count();

        return distinctCount != carNames.size();
    }

    private static boolean containsBlank(final List<String> carNames) {
        return carNames.stream()
                       .anyMatch(String::isBlank);
    }
}
