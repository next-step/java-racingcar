package racing.common;

public enum Script {
    CAR_NAMES_QUESTION("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TIME_COUNT_QUESTION("시도할 회수는 몇 회 인가요?"),
    WINNER_PRINT_SCRIPT(" 가 최종 우승했습니다.");
    
    private String message;
    
    Script(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
