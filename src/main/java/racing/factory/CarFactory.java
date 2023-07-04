package racing.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class CarFactory {

    private static final String DEFAULT_DELIMITER = ",";

    private static class CarFactoryHandler {
        private static final CarFactory INSTANCE = new CarFactory();
    }

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public List<Car> manufactureCars(String text) {
        return manufactureCars(text.split(DEFAULT_DELIMITER));
    }

    public List<Car> manufactureCars(String[] names) {
        return Arrays.stream(names)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }

}
