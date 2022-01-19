package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static Cars of() {
        return new Cars();
    }
}
