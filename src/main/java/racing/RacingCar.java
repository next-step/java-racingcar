package racing;

public class RacingCar {

    private int position;

    private RacingCar(int position) {
        this.position = position;
    }

    public static RacingCar init() {
        return new RacingCar(0);
    }

    public RacingCar move(final int moveCount) {
        return new RacingCar(position += moveCount);
    }

    public int getPosition() {
        return position;
    }
}
