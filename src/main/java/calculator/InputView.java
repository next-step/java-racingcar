package calculator;

public class InputView {
    private static final String BLANK = " ";
    private String input;
    private String[] inputArr;

    public InputView(String input) {
        validateNull(input);
        validateEmpty(input);
        this.input = input;
        inputArr = split();
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    public String[] split() {
        return input.split(BLANK);
    }

    public String[] getInputArr() {
        return inputArr;
    }
}
