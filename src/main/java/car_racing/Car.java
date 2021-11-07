package car_racing;

public class Car {
    private final StringBuilder position;
    private static final String MOVE_FORWARD = "-";

    public Car() {
        this.position = new StringBuilder();
    }

    /* test */
    public Car(String strPosition) {
        this.position = new StringBuilder(strPosition);
    }

    public void move() {
        if (ableToMove()) {
            position.append(MOVE_FORWARD);
        }
    }

    public String getCurrStatus() {
        return position.toString();
    }

    private boolean ableToMove() {
        int randomValue = (int) (Math.random() * 10);
        return randomValue >= 4;
    }

}
