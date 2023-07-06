package car.domain;

public final class TryCount {

    private final int tryCount;

    public TryCount(final String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(final String count) {
        int num = Integer.parseInt(count);
        if (num < 0) {
            throw new IllegalArgumentException("시도 횟수가 음수입니다.");
        }
        return num;
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
