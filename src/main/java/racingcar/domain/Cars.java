package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MIN_NO = 1;
    private static final String VALID_MIN_NO = "최소 자동차 1대 이상입니다.";
    private final List<Car> cars;

    public Cars(int no) {
        validateTotal(no);
        this.cars = mapCars(no);
    }

    private List<Car> mapCars(int no) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < no; i++) {
            cars.add(new Car());
        }

        return cars;
    }

    private void validateTotal(int no) {
        if (no < MIN_NO) {
            throw new IllegalArgumentException(VALID_MIN_NO);
        }
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(this.cars);
    }
}
