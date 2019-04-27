package racing;

public class RacingCar {
    public static final int MOVE_MIN_COUNT = 4;
    int position;

    public int move(int randomValue) {
        if (isMoving(randomValue))
            return position += 1;
        return position;
    }

    private boolean isMoving(int randomValue) {
        return randomValue >= MOVE_MIN_COUNT;
    }

    @Override
    public String toString() {
        String steps = "";
        for (int i = 0; i < position; i++) {
            steps += "-";
        }
        return steps;
    }
}
