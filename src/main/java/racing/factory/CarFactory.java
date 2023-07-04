package racing.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class CarFactory {

    private static final String DEFAULT_DELIMITER = ",";
    public static final int CAR_NAME_MAX = 5;

    private static class CarFactoryHandler {

        private static final CarFactory INSTANCE = new CarFactory();

    }

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public List<Car> manufactureCars(String text) {
        String[] carNames = text.split(DEFAULT_DELIMITER);

        if (!validate(carNames)) {
            throw new IllegalArgumentException("5자를 초과하는 자동차 이름은 사용할 수 없습니다.");
        }

        return manufactureCars(carNames);
    }

    private List<Car> manufactureCars(String[] names) {
        return Arrays.stream(names)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }

    private boolean validate(String[] carNames) {
        return Arrays.stream(carNames)
                     .filter(cur -> cur.length() > CAR_NAME_MAX)
                     .findAny()
                     .isEmpty();
    }

}
