package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int MIN_NUMBER = 1;

    private List<Car> cars = new ArrayList<>();

    public Cars(final int count) {
        validate(count);
        generate(count);
    }

    private void validate(final int count) {
        if (count < MIN_NUMBER) {
            throw new IllegalArgumentException("자동차는 1개 이상이여야 합니다.");
        }
    }

    private void generate(final int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car("", new RandomNumberGenerator()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
