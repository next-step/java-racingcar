package racingcar;

public class Car {
    int order;
    int position;

    public Car(int order) {
        this.order = order;
        this.position = 0;
    }

    public int moveForward() {
        this.position++;
        return position;
    }

    public String printPosition() {
        return "-".repeat(position);
    }
}
