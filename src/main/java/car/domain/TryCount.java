package car.domain;

public final class TryCount {

    private int tryCount;

    public TryCount(String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(String count) {
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
