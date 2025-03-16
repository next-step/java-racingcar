package game;

public class PositiveInteger {
    private int value;

    public PositiveInteger(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("0 과 양의 정수만 생성할 수 있습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void addOne() {
        value++;
    }
}
