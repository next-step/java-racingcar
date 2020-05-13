package racingcar.domain;

public class GameInfo {
    private static final int GAME_INFO_NUMBER_BOUND = 0;
    private final int numberOfCar;
    private final int numberOfPhase;

    public GameInfo(int numberOfCar, int numberOfPhase) {
        validateInputValue(numberOfCar, numberOfPhase);
        this.numberOfCar = numberOfCar;
        this.numberOfPhase = numberOfPhase;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfPhase() {
        return numberOfPhase;
    }

    private void validateInputValue(int numberOfCar, int numberOfPhase) {
        if (numberOfCar <= GAME_INFO_NUMBER_BOUND) {
            throw new IllegalArgumentException("참여할 자동차의 대수는 0 보다 커야합니다.");
        }

        if (numberOfPhase <= GAME_INFO_NUMBER_BOUND) {
            throw new IllegalArgumentException("시도할 횟수는 0 보다 커야합니다.");
        }
    }
}
