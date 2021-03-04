package step2;

public class Validator {

    // 공백 또는 빈 문자열 이라면 예외 발생
    public void isEmptyOrIsBlank(String input) {
        if (isBlank(input) || isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    public void isCheckOperation(String[] input) {
        for (int i = 1; i < input.length; i+=2) {
            // +, -, *, / 연산자가 아닐 때 예외 발생
            if (!isPlus(input[i]) && !isMinus(input[i]) && !isMultiply(input[i]) && !isDivide(input[i])) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isEmpty(String input) {
        return input.equals("");
    }

    private boolean isBlank(String input) {
        return input.equals(" ");
    }

    private boolean isPlus(String input) {
        return input.equals("+");
    }

    public boolean isMinus(String input) {
        return input.equals("-");
    }

    public boolean isMultiply(String input) {
        return input.equals("*");
    }

    public boolean isDivide(String input) {
        return input.equals("/");
    }
}
