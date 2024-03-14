package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {

    public static final String NAME_SEPARATOR = ",";

    public static List<RacingCar> createCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
            .mapToObj(i -> new RacingCar())
            .collect(Collectors.toList());
    }

    public static List<RacingCar> createCars(String namesOfCars) {
        return Arrays.stream(splitNames(namesOfCars))
            .map(CarName::new)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    private static String[] splitNames(String namesOfCars) {
        return namesOfCars.split(NAME_SEPARATOR);
    }
}
