package step3.domain;

public class Car {

    private int status;

    public Car() {
        this.status = 0;
    }

    public int getStatus() {
        return status;
    }

    public int moveCar(boolean move) {
        return move ? this.status++ : this.status;
    }

}
