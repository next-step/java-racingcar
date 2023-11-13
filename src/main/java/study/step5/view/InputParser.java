package study.step5.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import study.step5.domain.Car;


public class InputParser {

    public static final String DELIMITER = ",";

    public static List<Car> parse(String string) {
        String[] strings = string.split(DELIMITER);
        return Arrays.stream(strings)
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
