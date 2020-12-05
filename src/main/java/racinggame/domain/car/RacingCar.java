package racinggame.domain.car;

public class RacingCar {
    private final int position;

    public RacingCar(int position) {
        this.position = position;
    }

    public RacingCar move(boolean isMove) {
        if (isMove) {
            return new RacingCar(position + 1);
        }
        return this;
    }

    public int getPosition() {
        return position;
    }
}
