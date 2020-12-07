package racinggame.domain.car;

public class RacingCar{
    private final CarName name;
    private final int position;

    public RacingCar(final CarName name, final int position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar move(final boolean isMove) {
        if (isMove) {
            return new RacingCar(name, position + 1);
        }
        return this;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
