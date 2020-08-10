package racingcar.car;

public class Car {
    private int status = 1;

    public Car() {
    }

    public Car(int customStatus) {
        this.status = customStatus;
    }

    public int getStatus() {
        return status;
    }

    public void move(int forward) {
        this.status = this.status + forward;
    }
}