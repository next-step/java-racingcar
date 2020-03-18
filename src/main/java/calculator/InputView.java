package calculator;

public class InputView {
    private String input;

    public InputView(String input) {
        validateNull();
        validateEmpty();
        this.input = input;
    }

    private void validateNull() {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void validateEmpty() {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    public String[] split() {
        return new String[0];
    }
}
