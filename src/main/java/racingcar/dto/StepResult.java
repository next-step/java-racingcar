package racingcar.dto;

import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class StepResult {
    private static final String ERROR_MESSAGE_NOT_EXIST_MAX_SCORE = "우승스코어가 존재하지 않습니다.";

    private List<StepByCar> stepByCarList;

    private StepResult(List<StepByCar> stepByCarList) {
        this.stepByCarList = stepByCarList;
    }

    public static StepResult of(Cars cars) {
        return new StepResult(cars.getStepByCar());
    }

    public List<StepByCar> getStepByCar() {
        return stepByCarList;
    }

    public int getMaxScore() {
        return this.stepByCarList.stream()
                .map(StepByCar::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_MAX_SCORE));
    }

    public List<String> getWinnerName() {
        return this.stepByCarList.stream()
                .filter(v -> v.getPosition() == getMaxScore())
                .map(StepByCar::getName)
                .collect(Collectors.toList());
    }
}
