package step2;

public class Numbers {
    private static final String DEFAULT_VALUE = "0";
    private final String numbers;

    public Numbers(String numbers) {
        this.numbers = vaildation(numbers);
    }

    public String numbers() {
        return numbers;
    }

    private static String vaildation(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return DEFAULT_VALUE;
        }
        if (!numbers.matches("(.*)[\n]*[0-9](.*)")) {
            throw new RuntimeException("숫자가 없습니다.");
        }
        if (numbers.matches("(.*)-[0-9](.*)")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return numbers;
    }
}
