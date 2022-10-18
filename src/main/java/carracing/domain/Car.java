package carracing.domain;

public class Car {
    private static final String DASH = "-";
    private int carId;
    private int position;

    public Car(final int carId) {
        this(carId, 0);
    }

    public Car(final int carId, final int position) {
        this.carId = carId;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public String makePositionToDash() {
        return DASH.repeat(this.position);
    }
}
