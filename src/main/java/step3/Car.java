package step3;

public class Car {

    private static final int DEFAULT_CAR_POSITION = 1;

    private int position;

    public Car() {
        position = DEFAULT_CAR_POSITION;
    }

    public void moveCar() {
        this.position = position++;
    }

    public int getPosition() {
        return position;
    }

}
