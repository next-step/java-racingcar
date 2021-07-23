package study.step3;

public class Car {

    private static final String CAR_SHAPE = "-";
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    public String getShape() {
        return CAR_SHAPE;
    }

    public int getPosition() {
        return position;
    }
}
