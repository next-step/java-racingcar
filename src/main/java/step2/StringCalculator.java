package step2;

import java.util.Arrays;

public class StringCalculator {
    private final String numbers;


    public StringCalculator(String numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(String numbers) {
        if (numbers != null && !numbers.isEmpty() && !numbers.matches(".*[\n]*[0-9].*")) {
            throw new RuntimeException("숫자가 없습니다.");
        }
        if (numbers != null && numbers.matches("(.*)-\\d(.*)")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int calculate() {
        if (numbers == null) {
            return 0;
        }
        if (numbers.isEmpty()) {
            return 0;
        }
        String regex = getRegex();

        return Arrays.stream(numbers.replaceAll("//\\D\\n", "").split(regex))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getRegex() {
        String regex = "[,|:]";
        if (numbers.contains("//")) {
            regex = String.valueOf(numbers.substring(2).charAt(0));
        }
        return regex;
    }
}
