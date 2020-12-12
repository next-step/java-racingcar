package racingcar.domain;

import racingcar.util.ValidateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final String VALID_MIN_NO = "최소 자동차 1대 이상입니다.";

    private final RacingResult racingResult = new RacingResult();
    private final RandomNumber randomNumber = new RandomNumber();
    private final List<Car> cars = new ArrayList<>();

    public Cars(int no) {
        validateTotal(no);
        for (int i = 0; i < no; i++) {
            this.cars.add(new Car());
        }
    }

    private void validateTotal(int no) {
        if (ValidateUtils.validateMin(no)) {
            throw new IllegalArgumentException(VALID_MIN_NO);
        }
    }

    public void run() {
        for (Car car : cars) {
            car.play(randomNumber.condition());
        }
        racingResult.report(cars);
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(this.cars);
    }

    public RacingResult getRacingResult() {
        return racingResult;
    }
}
