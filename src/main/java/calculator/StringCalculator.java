package calculator;

public class StringCalculator {

    public String[] splitValue(String value) {
        return value.split(" ");
    }

    public int calculate(String value) {
        verifyInputValue(value);
        return doCalculate(splitValue(value));
    }

    public int doCalculate(String[] values) {
        int result = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            result = Operator.operate(result, String.valueOf(values[i + 1].charAt(0)), Integer.parseInt(values[i + 2]));
        }
        return result;
    }

    public void verifyInputValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백입니다.");
        }
    }

}