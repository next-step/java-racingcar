package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private List<CarName> names;

    public CarNames(String names) {
        List<String> parsedNames = parseCarNames(names);

        if (parsedNames.size() == 0) {
            throw new IllegalArgumentException();
        }

        this.names = parsedNames.stream()
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    private List<String> parseCarNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Car> generateCars() {
        return this.names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }


}
