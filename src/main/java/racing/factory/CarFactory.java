package racing.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;

public class CarFactory {

    private static class CarFactoryHandler {
        private static final CarFactory INSTANCE = new CarFactory();
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public List<Car> manufactureCars(String text) {
        return manufactureCars(text.split(","));
    }

    public List<Car> manufactureCars(String[] names) {
        return Arrays.stream(names)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }

}
