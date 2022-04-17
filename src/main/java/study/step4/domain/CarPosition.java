package study.step4.domain;

public class CarPosition {
    private final int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition forward() {
        return new CarPosition(position + 1);
    }

    public int getPosition() {
        return position;
    }
}
