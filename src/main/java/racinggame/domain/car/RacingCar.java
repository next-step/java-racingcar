package racinggame.domain.car;

public class RacingCar {
    private final String name;
    private final int position;

    public RacingCar(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar move(final boolean isMove) {
        if (isMove) {
            return new RacingCar(name, position + 1);
        }
        return this;
    }

    public int getPosition() {
        return position;
    }
}
