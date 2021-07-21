package racing.domain;

public class Count {

    private final int count;

    public Count(int count) {
        if (isNotPositiveNumber(count)) {
            throw new IllegalArgumentException("0보다 큰 숫자여야 합니다.");
        }

        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private boolean isNotPositiveNumber(int num) {
        return num < 1;
    }
}
