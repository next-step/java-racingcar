package racingcar;

public class Car {

    private int position;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position ++;
    }
}
