package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameSplitter {
    private static final String DELIMITER = ",";

    private CarNameSplitter() {}

    public static List<CarName> names(String nameSting) {
        return Arrays.stream(nameSting.split(DELIMITER)).map(carName -> new CarName(carName)).collect(Collectors.toList());

    }
}
