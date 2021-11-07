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

    private boolean isNotNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        return true;
    }

    public MyNumber calculate() {
        if (inputArr.length % 2 != 0) {
            return compute(inputArr);
        }
        throw new IllegalArgumentException("유효하지 않은 계산 식 입니다.");
    }


    private MyNumber compute(String[] input) {
        MyNumber left = new MyNumber(input[0]);
        for (int i = 1; i < inputArr.length; i += 2) {
            String operator = inputArr[i];
            MyNumber right = new MyNumber(inputArr[i + 1]);
            left = Operator.of(operator).operate(left, right);
        }
        return left;
    }
}
