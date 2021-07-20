package calculator.racinggame;

public class Count {

    private final int count;

    public Count(int count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException("시도할 회수는 0보다 큰 숫자여야 합니다.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private boolean isValid(int count) {
        return count > 0;
    }
}
