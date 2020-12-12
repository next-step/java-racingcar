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
        validateCars(no);
        for (int i = 0; i < no; i++) {
            this.cars.add(new Car());
        }
    }

    private void validateCars(int carCount) {
        if (ValidateUtils.validateMin(carCount)) {
            throw new IllegalArgumentException(VALID_MIN_NO);
        }
    }

    public void run() {
        for (Car car : cars) {
            int randomCondition = randomNumber.condition();
            car.play(randomCondition);
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
