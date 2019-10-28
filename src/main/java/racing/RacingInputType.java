package racing;

public enum RacingInputType {
    CAR("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TRY("시도할 회수는 몇 회 인가요?");

    private String message;

    RacingInputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
