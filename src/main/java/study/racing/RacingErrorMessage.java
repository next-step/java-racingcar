package study.racing;

import study.racing.view.InputView;

public enum RacingErrorMessage {
    ZERO_CAR_COUNT(0, "자동차 대수는 0대일 수 없습니다."),
    ZERO_TRY_COUNT(1, "시도 횟수는 0회일 수 없습니다."),
    OVER_MAX_NAME_LENGTH(2, "자동차의 이름은 "+InputView.MAX_CAR_NAME_LENGTH+"자를 초과할 수 없습니다.");

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
