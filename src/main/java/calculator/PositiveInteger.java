package calculator;

public class PositiveInteger {
    private final int number;

    public PositiveInteger(String input) {
        if(!isNumber(input)) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다.");
        }

        int number = Integer.parseInt(input);
        if(number < 0) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private static boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }
}
