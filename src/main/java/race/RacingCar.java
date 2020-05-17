package race;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;
    private int position;

    private RacingCar(int position) {
        this.position = position;
    }

    public static RacingCar ready() {
        return new RacingCar(DEFAULT_POSITION);
    }

    public int forward() {
        return ++position;
    }

    public int stop() {
        return position;
    }

    public int getPosition() {
        return position;
    }
}
