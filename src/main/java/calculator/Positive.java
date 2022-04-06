package calculator;

public class Positive {
    private int number;

    Positive(String value) {
        this(Integer.parseInt(value));
    }

    Positive(int number) {
        if(number < 0)  throw new RuntimeException("음수 입력시 예외가 발생합니다.");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
