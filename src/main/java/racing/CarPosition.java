package racing;

public class CarPosition {
    private final int position;

    public CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("현재 위치 값이 음수일 수는 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public CarPosition move() {
        return new CarPosition(position+1);
    }
}
