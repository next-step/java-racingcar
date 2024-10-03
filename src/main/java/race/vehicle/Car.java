package race.vehicle;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int location = 1;

    public void move(int number) {
        if (isMovable(number)) {
            this.location++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    public int getLocation() {
        return this.location;
    }

}
