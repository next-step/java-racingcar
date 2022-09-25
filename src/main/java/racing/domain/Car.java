package racing.domain;

public class Car {

    private static final String WHEEL_MARKS = "-";

    private StringBuilder position = new StringBuilder(WHEEL_MARKS);

    public void move(boolean move) {
        if (move) {
            this.position = position.append(WHEEL_MARKS);
        }
    }

    public String getPosition() {
        return position.toString();
    }
}
