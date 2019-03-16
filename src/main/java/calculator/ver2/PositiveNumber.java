package calculator.ver2;

public class PositiveNumber {
    private int number;

    public PositiveNumber(String number) {
        this.number = filterValidValue(number);
    }

    private int filterValidValue(String number) {
        try {
            int temp = Integer.parseInt(number);
            if (temp < 0) {
                throw new RuntimeException("음수는 유효하지 않은 값입니다.");
            }
            return temp;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 유효하지 않습니다.");
        }
    }

    public void add(PositiveNumber anotherNumber) {
        this.number += anotherNumber.number;
    }

    public void print() {
        System.out.println(number);
    }

    public int getNumber() {
        return number;
    }
}
