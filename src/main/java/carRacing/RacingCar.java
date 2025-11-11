package carRacing;

public class RacingCar {

    public static final int MOVE_CONDITION = 4;
    private int position;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void movePosition() {
        position++;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            movePosition();
        }
    }
}
