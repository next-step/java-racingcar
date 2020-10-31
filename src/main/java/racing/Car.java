package racing;

public class Car {

    private static final String MOVEMENT = "-";

    private final StringBuilder displacement;

    public Car() {
        this.displacement = new StringBuilder();
    }

    public void move(boolean canMove) {
        if (canMove) {
            displacement.append(MOVEMENT);
        }
    }

    public String getDisplacement() {
        return displacement.toString();
    }
}
