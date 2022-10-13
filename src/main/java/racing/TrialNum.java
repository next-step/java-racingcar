package racing;

public class TrialNum {
    private final int value;

    public TrialNum(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
