package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cars {
    private final List<Car> cars;

    Cars(List<Car> input) {
        validate(input);
        List<Car> cars = new ArrayList<>(input);
        this.cars = cars;
    }

    private void validate(List<Car> input) {
        Objects.requireNonNull(input, "전달된 리스트가 올바르지 않습니다 : Cars is null");

        if (input.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : Cars is empty");
        }
    }
}
