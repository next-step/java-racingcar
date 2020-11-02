package step4.utils;

import step4.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNameSplitter {
    private static final String SPLIT_SEPARATOR = ",";

    public static List<Car> splitToCarList(String input){
        return Arrays.stream(input.split(SPLIT_SEPARATOR))
                .map(Car::new).collect(Collectors.toList());
    }
}
