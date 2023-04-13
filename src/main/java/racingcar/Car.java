package racingcar;

public class Car {

    public static final int SET_POSITION = 1;

    private Integer position;

    public Car() {
        this.position = SET_POSITION;
    }

    protected Car(int position) {
        this.position = position;
    }

    public int position() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    public Car clone() {
        return new Car(this.position);
    }

}
