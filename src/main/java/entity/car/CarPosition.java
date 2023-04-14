package entity.car;

public class CarPosition {

    private final int position;

    public CarPosition(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("차 움직임은 음수일 수 없습니다.");
        }
    }

    public CarPosition move() {
        return new CarPosition(this.position + 1);
    }

    public int getPositionValue() {
        return position;
    }
}
