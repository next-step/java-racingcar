package step3.models;

import java.util.List;
import java.util.stream.Collectors;
import step3.utils.StringSpliter;

public class CarFactory {
    private final String string;

    public CarFactory(String string) {
        this.string = string;
    }

    public List<Car> createCarList() {
        return StringSpliter.split(this.string).stream()
                .map(Car::init)
                .collect(Collectors.toList());
    }
}
