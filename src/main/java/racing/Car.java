package racing;

public class Car {

    private static final String MOVEMENT = "-";

    private StringBuilder displacement;

    public Car() {
        this.displacement = new StringBuilder();
    }

    public void move() {
        displacement.append(MOVEMENT);
    }

    public String getDisplacement() {
        return displacement.toString();
    }
}
