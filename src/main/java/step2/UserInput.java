package step2;

public class UserInput {
    private static final String DEFAULT_VALUE = "0";

    private final String value;

    public UserInput(String numbers) {
        this.value = validation(numbers);
    }

    public String value() {
        return value;
    }

    private static String validation(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return DEFAULT_VALUE;
        }
        if (!numbers.matches("(//.*\n)?.*[0-9].*")) {
            throw new RuntimeException("숫자가 없습니다.");
        }
        if (numbers.matches("(//.*\n)?.*-[0-9].*")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return numbers;
    }
}
