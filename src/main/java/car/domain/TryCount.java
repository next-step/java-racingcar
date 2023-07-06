package car.domain;

public final class TryCount {

    private int tryCount;

    public TryCount(String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(String count) {
        try {
            int num = Integer.parseInt(count);
            if (num < 0) {
                throw new RuntimeException("시도 횟수가 음수입니다.");
            }
            return num;
        } catch (RuntimeException e) {
            throw new RuntimeException("시도 횟수 입력이 잘못 되었습니다.");
        }
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
