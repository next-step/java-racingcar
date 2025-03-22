package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Cars create(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 적어도 하나 이상이어야 합니다.");
        }

        return new Cars(names.stream()
                .distinct()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

}
