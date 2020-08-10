package racingcar.car;

public class Car {
    private int status = 1;

    public Car(int customStatus) {
        this.status = customStatus;
    }

    public Car() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
