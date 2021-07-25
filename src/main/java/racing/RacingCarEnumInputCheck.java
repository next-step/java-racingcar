package racing;

public enum RacingCarEnumInputCheck {
    NUM_OF_CAR(5,"자동차의 수가 너무 적거나 많습니다. (range: 1~5)"),
    CYCLE_OF_RACING(10, "시도할 회수가 너무 적거나 많습니다. (range: 1~10)");

    private final int threthold;
    private final String errorMessage;

    RacingCarEnumInputCheck(int threthold, String errorMessage) {
        this.threthold = threthold;
        this.errorMessage = errorMessage;
    }

    public void validInputCheck(int cnt) {
        if (0 >= cnt || threthold < cnt ) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
