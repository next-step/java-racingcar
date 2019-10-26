package racing;

public enum RacingInputType {
    CAR("자동차 대수는 몇 대 인가요?"),
    TRY("시도할 회수는 몇 회 인가요?");

    private String message;

    RacingInputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
