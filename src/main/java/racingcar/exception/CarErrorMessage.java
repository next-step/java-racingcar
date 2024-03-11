package racingcar.exception;

public enum CarErrorMessage {

    NEGATIVE_DISTANCE("자동차 전진 거리는 음수값을 가질 수 없습니다.");

    private final String errorMessage;


    CarErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
