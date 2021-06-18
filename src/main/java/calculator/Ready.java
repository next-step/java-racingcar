package calculator;

public class Ready {
    private static final String WHITE_SPACE = " ";

    public String[] splitMathQuiz(String mathQuiz) {
        validateBlank(mathQuiz);
        return splitter(mathQuiz);
    }

    private static void validateBlank(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    private String[] splitter(String input) {
        return input.split(WHITE_SPACE);
    }
}
