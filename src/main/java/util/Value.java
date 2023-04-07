package util;

public class Value {
    int value;

    public Value(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
