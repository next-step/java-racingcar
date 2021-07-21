package racinggame.car;

public class Count {

    private final int count;

    public Count(int count) {
        if (!isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도할 회수는 0보다 큰 숫자여야 합니다.");
        }
        this.count = count;
    }

    public static Count of(int count) {
        return new Count(count);
    }

    public int getCount() {
        return count;
    }

    private boolean isPositiveNumber(int num) {
        return num > 0;
    }
}
