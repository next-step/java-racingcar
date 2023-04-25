package racingcar.domain;

import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingProcess {
    private final String carName;
    private final int periodCount;

    public RacingProcess(String carNames, int periodCount) {
        carNameValidation(carNames);
        countValidation(periodCount);

        this.carName = carNames;
        this.periodCount = periodCount;
    }

    public List<Cars> racingStart() {
        Cars cars = Cars.generateCars(carName);

        return iterateRacing(cars);
    }

    private List<Cars> iterateRacing(Cars cars) {
        List<Cars> roundResult = new ArrayList<>();
        roundResult.add(cars.getClone());
        for (int i = 1; i < periodCount; i++) {
            cars.checkForwardConditionAndGo();
            roundResult.add(cars.getClone());
        }

        return roundResult;
    }

    private void countValidation(int count) {
        if (count < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private void carNameValidation(String carNames) {
        if (carNames == null || "".equals(carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요");
        }
    }

}
