package race;

public class RacingCar {
    private int position;

    public boolean shouldMove(int num) {
        return num >= 4;
    }

    public String move(int i) {
        if (shouldMove(i)) {
            position++;
        }

        return "-".repeat(Math.max(0, position));
    }
}
