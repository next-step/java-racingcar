package step3.view;

public class InputView {
    public static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String FIRST_QUESTION = "자동차 대수는 몇 대 인가요?";
    private int theNumberOfCar;
    private int theNumberOfTrials;

    public String askQuestion(String value) {
        if (value.equals("1")) {
            return FIRST_QUESTION;
        }
        if (value.equals("2")) {
            return SECOND_QUESTION;
        }

        return "잘못된 인자값입니다.";
    }

    public void enterAnswerForQuestion(String questionNumber, int value) {
        if (questionNumber.equals("1")) {
            this.theNumberOfCar = value;
        }
        if (questionNumber.equals("2")) {
            this.theNumberOfTrials = value;
        }
    }

    public int getAnswer(String questionNumber) {
        if (questionNumber.equals("1")) {
            return this.theNumberOfCar;
        }
        if (questionNumber.equals("2")) {
            return this.theNumberOfTrials;
        }
        return 0;
    }
}
