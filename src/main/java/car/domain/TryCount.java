package car.domain;

public class TryCount {

    private int tryCount;

    public TryCount(String count) {
        this.tryCount = toInt(count);
    }

    private int toInt(String count) {
        int num = Integer.parseInt(count);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    public int getTryCount() {
        return this.tryCount;
    }

}
