package step4.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private String carName;
    public int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }
}
