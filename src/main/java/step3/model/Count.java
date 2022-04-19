package step3.model;

public class Count {

    private final int value;

    public Count(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("count 는 1 보다 작을 수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
