package racing.domain;

public class Distance {
    private int value;

    public Distance() {
        this.value = 0;
    }

    public Distance(int distance) {
        this.value = distance;
    }

    public int value() {
        return this.value;
    }
    public boolean isEqual(int distance) {
        return value == distance;
    }

    public boolean isGreater(int distance) {
        return value > distance;
    }

    public int maxNum(int distance) {
        return Math.max(value, distance);
    }

    public void addDistance() {
        value++;
    }

}
