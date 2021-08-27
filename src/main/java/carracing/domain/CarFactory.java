package carracing.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> makeCars(String[] names) {
        return Arrays.stream(names)
            .map(Car::new)
            .collect(toList());
    }

}
