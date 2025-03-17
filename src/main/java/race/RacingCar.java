package race;

public class RacingCar {
    private int position;

    public boolean shouldMove(int num) {
        return num >= 4;
    }

    public int move(int i) {
        if (shouldMove(i)) {
            position++;
        }
        return position;
    }

    public void printPosition() {
        System.out.println("|" + "-".repeat(Math.max(0, position)));
    }
}
