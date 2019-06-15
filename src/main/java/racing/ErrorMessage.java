package racing;

public enum ErrorMessage {
    INCORRECT_TIME("실행 횟수는 1~100까지만 입력이 가능합니다."),
    INCORRECT_CAR_COUNT("차의 댓수는 1~100까지만 입력이 가능합니다.");
    
    private String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
