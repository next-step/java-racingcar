package calculator;

public class PositiveNumber {

    private final int value;
    
    public static final PositiveNumber ZERO = new PositiveNumber(0);

    public PositiveNumber(String value) {
        this(Integer.parseInt(value));
    }

    public PositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public PositiveNumber plus(PositiveNumber other) {
        return new PositiveNumber(this.value + other.value);
    }
    
    public int toInt() {
        return value;
    }
    
}