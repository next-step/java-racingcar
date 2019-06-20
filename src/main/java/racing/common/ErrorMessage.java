package racing.common;

public enum ErrorMessage {
    INCORRECT_TIME("실행 횟수는 1~100까지만 입력이 가능합니다."),
    INCORRECT_CAR_NAMES("자동차의 이름을 정확히 입력해주세요. ex) aa,bb,cc");
    
    private String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
