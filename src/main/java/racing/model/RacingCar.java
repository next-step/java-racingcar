package racing.model;

public class RacingCar {

    public static final int THRESHOLD_POWER = 4;

    private int position;

    public boolean move(int power) {
        if (power < THRESHOLD_POWER) {
            return false;
        }

        this.position++;
        return true;
    }

    public int getPosition() {
        return position;
    }
}
