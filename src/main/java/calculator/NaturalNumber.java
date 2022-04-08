package calculator;

public class NaturalNumber {

    private final int number;

    public NaturalNumber(String number) {
        this(Integer.parseInt(number));
    }

    public NaturalNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
