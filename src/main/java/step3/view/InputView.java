package step3.view;

public class InputView {
    public static final String FIRST_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String SECOND_QUESTION = "시도할 회수는 몇 회 인가요?";
    public static final String WRONG_ARGUMENT = "잘못된 인자입니다.";

    public String askQuestion(String value) {
        if (value.equals("1")) {
            return FIRST_QUESTION;
        }
        if (value.equals("2")) {
            return SECOND_QUESTION;
        }

        return WRONG_ARGUMENT;
    }
}
