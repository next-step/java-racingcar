package step3.domain;

public class InputCar {

    private final int count;

    private final int retry;

    public InputCar(int count, int retry) {
        validate(count, retry);
        
        this.count = count;
        this.retry = retry;
    }

    private void validate(int count, int retry) {
        if (count < 0 || retry < 0) {
            throw new IllegalArgumentException("count, retry should be positive - count: " + count + ", retry: " + retry);
        }
    }

    public int getCount() {
        return count;
    }

    public int getRetry() {
        return retry;
    }
}
