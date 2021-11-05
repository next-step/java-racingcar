package stringcalculator;

public class Number {
    private final int number;

    private Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력 해주세요");
        }
    }

    private Number (int number) {
        this.number = number;
    }

    public static Number from(String num) {
        return new Number(num);
    }

    public static Number from(int num) {
        return new Number(num);
    }

    public int getNumber() {
        return number;
    }
}
