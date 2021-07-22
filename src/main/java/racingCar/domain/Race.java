package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Race(int count) {
        validateInput(count);
    }

    private void validateInput(int count) {
        if(count < 1) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

}
