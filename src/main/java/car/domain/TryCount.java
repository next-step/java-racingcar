package car.domain;

public final class TryCount {

    private int tryCount;

    public TryCount(String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(String count) {
        try {
            int num = Integer.parseInt(count);
            return num;
        } catch (Exception e) {
            throw new RuntimeException("시도 횟수 입력이 잘못 되었습니다.");
        }
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
