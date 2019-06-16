package racing.common;

public enum Question {
    CAR_COUNT("자동차 대수는 몇 대 인가요?"),
    TIME_COUNT("시도할 회수는 몇 회 인가요?");
    
    private String message;
    
    Question(String message) {
        this.message = message;
    }
    
    public String getQuestion() {
        return message;
    }
}
