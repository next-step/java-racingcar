package step4;

public class Car {
    private final String carName;
    private Integer position = 0;

    public Car(final String carName, int position) {

        this.carName = carName;
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}
