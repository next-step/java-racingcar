package racing.factory;

import java.util.List;
import java.util.stream.Collectors;
import racing.exception.GameReadyException;
import racing.model.Car;
import racing.model.Cars;

public class CarFactory {

    private static class CarFactoryHandler {
        private static final CarFactory INSTANCE = new CarFactory();
    }

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public Cars manufactureCars(final List<String> carNames) {
        if (hasDuplicatedNames(carNames)) {
            throw new GameReadyException("중복된 자동차 이름을 사용할 수 없습니다.");
        }

        final List<Car> cars = carNames.stream()
                                       .map(Car::new)
                                       .collect(Collectors.toUnmodifiableList());
        return new Cars(cars);
    }

    private static boolean hasDuplicatedNames(final List<String> carNames) {
        final long distinctCount = carNames.stream()
                                           .distinct()
                                           .count();
        return distinctCount != carNames.size();
    }
}
