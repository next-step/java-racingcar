package step3.domain;

public class Car {
    private final int state;

    public Car(int state) {
        this.state = state;
    }


    public Car move() {
        return new Car(state + 1);
    }

    public int state() {
        return state;
    }
}
