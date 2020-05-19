package step3;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    public RacingCar(int position) {
        this.position = position;
    }

    public static RacingCar ready() {
        return new RacingCar(DEFAULT_POSITION);
    }

    public int forward() {
        return ++position;
    }

    public int currentPosition() {
        return position;
    }
}
