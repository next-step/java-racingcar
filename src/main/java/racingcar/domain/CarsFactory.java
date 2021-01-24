package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static Cars createCars(String carNames, MoveChecker moveChecker) {
        List<Car> carList = new ArrayList<>();

        validateCarNames(carNames);
        for (String carName : carNames.split(DELIMITER)) {
            validateCarName(carName);

            Car car = new Car(carName, 0);
            carList.add(car);
        }

        return new Cars(carList, moveChecker);
    }

    private static void validateCarNames(String carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException("자동차들의 이름 입력값이 없습니다.");
        }
    }

    private static void validateCarName(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}