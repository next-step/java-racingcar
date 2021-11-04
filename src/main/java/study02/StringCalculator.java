package study02;

/**
 * .
 */
public class StringCalculator {

    private static final String DELIMITER = " ";
    private String[] inputArr;

    public StringCalculator(String input) {
        if (isNotNullOrEmpty(input)) {
            this.inputArr = input.split(DELIMITER);
        }

    }

    public CustomNumber calculate() {
        if (inputArr.length % 2 != 0) {
            return compute(inputArr);
        }
        throw new IllegalArgumentException("유효하지 않은 계산 식 입니다.");
    }

    private boolean isNotNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        return true;
    }

    private CustomNumber compute(String[] input) {
        CustomNumber left = new CustomNumber(input[0]);
        for (int i = 1; i < inputArr.length; i += 2) {
            String operator = inputArr[i];
            CustomNumber right = new CustomNumber(inputArr[i + 1]);
            left = Operator.of(operator).operate(left, right);
        }
        return left;
    }
}
