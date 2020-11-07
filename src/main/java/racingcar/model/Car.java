package racingcar.model;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private int position;
    private Motor motor;

    public Car(Motor motor) {
        this.position = INITIAL_POSITION;
        this.motor = motor;
    }

    public void run() {
        motor.run(this);
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
