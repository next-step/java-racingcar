package racingGame.view;

public enum QuestionType {
    CARS("자동차 대수는 몇 대 인가요?"),
    TIMES("시도할 회수는 몇 회 가요?");

    private String question;

    QuestionType(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
}
