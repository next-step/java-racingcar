package study.step3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DriverRecruiter {

    public static final String NOT_NULL = "입력되는 차량 리스트 값이 null 일수 없습니다";

    public List<Driver> recruit(List<Car> cars) {
        validation(cars);
        return cars.stream()
                .map(Driver::new)
                .collect(Collectors.toList());
    }

    private void validation(List<Car> cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException(NOT_NULL);
        }
    }
}
