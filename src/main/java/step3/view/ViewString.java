package step3.view;

public enum ViewString {
    HOW_MANY_CAR_QUESTION("자동차 대수는 몇 대 인가요?"),
    HOW_MUCH_ATTEMPT_QUESTION("시도할 회수는 몇 회 인가요?"),
    NEWLINE("\n"),
    RESULT_ANNOUNCEMENT(NEWLINE + "실행결과" + NEWLINE),
    ROUND_ANNOUNCEMENT("라운드"),
    MOVE_CHAR("-"),
    ;

    private final String value;

    ViewString(final String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
