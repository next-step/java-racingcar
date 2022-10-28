package racingcarwinner;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = DEFAULT_POSITION;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
