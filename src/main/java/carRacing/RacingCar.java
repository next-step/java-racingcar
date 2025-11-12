package carRacing;

public class RacingCar {

    public static final int MOVE_CONDITION = 4;
    private int position;
    private CarName name;

    public RacingCar(String name) {
            this.name = new CarName(name);
    }

    public String getName() {
        return name.getValue();
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
