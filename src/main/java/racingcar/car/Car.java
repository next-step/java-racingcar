package racingcar.car;

public class Car {
    private static final int DEFAULT_STATUS = 1;
    private int status;

    public Car() {
        this.status = DEFAULT_STATUS;
    }

    public Car(int customStatus) {
        this.status = customStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
