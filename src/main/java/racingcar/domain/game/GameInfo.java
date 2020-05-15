package racingcar.domain.game;

import java.util.Objects;

public class GameInfo {
    private static final int GAME_INFO_NUMBER_BOUND = 0;
    private static final String DELIMITER = ",";
    private int numberOfCar;
    private final int numberOfPhase;
    private String[] nameOfCars;

    public GameInfo(int numberOfCar, int numberOfPhase) {
        validateInputValue(numberOfCar, numberOfPhase);
        this.numberOfCar = numberOfCar;
        this.numberOfPhase = numberOfPhase;
    }

    public GameInfo(String nameOfCars, int numberOfPhase) {
        validateInputValue(nameOfCars, numberOfPhase);
        this.nameOfCars = nameOfCars.split(DELIMITER);
        this.numberOfPhase = numberOfPhase;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    public String[] getNameOfCars() {
        return nameOfCars;
    }

    private void validateInputValue(int numberOfCar, int numberOfPhase) {
        if (numberOfCar <= GAME_INFO_NUMBER_BOUND) {
            throw new IllegalArgumentException("참여할 자동차의 대수는 0 보다 커야합니다.");
        }

        if (numberOfPhase <= GAME_INFO_NUMBER_BOUND) {
            throw new IllegalArgumentException("시도할 횟수는 0 보다 커야합니다.");
        }
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
