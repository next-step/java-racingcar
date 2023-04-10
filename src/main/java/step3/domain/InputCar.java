package step3.domain;

public class InputCar {

    private final int count;

    private final int retry;

    public InputCar(int count, int retry) {
        this.count = count;
        this.retry = retry;
    }

    public int getCount() {
        return count;
    }

    public int getRetry() {
        return retry;
    }
}
