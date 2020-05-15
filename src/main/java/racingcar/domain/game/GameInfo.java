package racingcar.domain.game;

import java.util.Objects;

public class GameInfo {
    private static final int GAME_INFO_NUMBER_BOUND = 0;
    private static final String CAR_SPLIT_DELIMITER = ",";
    private final int numberOfPhase;
    private String[] nameOfCars;

    public GameInfo(String nameOfCars, int numberOfPhase) {
        validateInputValue(nameOfCars, numberOfPhase);
        this.nameOfCars = nameOfCars.split(CAR_SPLIT_DELIMITER);
        this.numberOfPhase = numberOfPhase;
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    public String[] getNameOfCars() {
        return nameOfCars;
    }

    private void validateInputValue(String nameOfCars, int numberOfPhase) {
        if (Objects.isNull(nameOfCars) || nameOfCars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        if (numberOfPhase <= GAME_INFO_NUMBER_BOUND) {
            throw new IllegalArgumentException("시도할 횟수는 0 보다 커야합니다.");
        }
    }
}
