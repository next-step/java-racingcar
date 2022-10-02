package racing.util;

import racing.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private StringUtil(){};
    private static final String COMMA = ", ";
    public static String getNameInCarList(List<Car> cars) {
        return cars.stream()
                .map(it -> it.getName())
                .collect(Collectors.joining(COMMA));
    }
}
