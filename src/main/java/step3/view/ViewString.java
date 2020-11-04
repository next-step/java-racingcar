package step3.view;

public enum ViewString {
    ENTER_THE_NAME_OF_THE_CARS("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
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
