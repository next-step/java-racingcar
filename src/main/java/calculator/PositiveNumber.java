package calculator;

public class PositiveNumber {
    private int number;

    public PositiveNumber(String number) {
        this.number = convertNumber(number);
    }

    private int convertNumber(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new RuntimeException("음수입력");
        }

        return num;
    }

    public int getNumber() {
        return number;
    }
}
