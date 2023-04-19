package step3.domain;

public class CarPosition {
    private int value;

    public CarPosition(int position) {
        this.value = position;
    }

    public static CarPosition of(int position) {
        return new CarPosition(position);
    }

    public void move() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
