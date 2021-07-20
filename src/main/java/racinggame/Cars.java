package racinggame;

import racinggame.util.Validator;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(int count) {
        if (!Validator.isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도할 회수는 0보다 큰 숫자여야 합니다.");
        }
    }
}
