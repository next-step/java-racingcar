package study.racing;

public enum RacingErrorMessage {
    ZERO_CAR_COUNT(0, "자동차 대수는 0대일 수 없습니다."),
    ZERO_TRY_COUNT(0, "시도 횟수는 0회일 수 없습니다.");

    private int code;
    private String errorMessage;

    RacingErrorMessage(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
