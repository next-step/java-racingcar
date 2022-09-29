package racingcar.constant;

public enum Question {
    ROUND("시도할 회수는 몇 회 인가요?"),
    CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

    private final String question;

    Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
