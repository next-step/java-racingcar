package study.step3.domain;

public class Car {

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
