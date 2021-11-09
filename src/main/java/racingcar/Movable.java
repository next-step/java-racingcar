package racingcar;

public class Movable {
    private static final int THRESHOLD = 4;

    public boolean valid(int fuel) {
        if (fuel >= THRESHOLD) {
            return true;
        }

        return false;
    }
}
