package racingcar;

public class Car {
    public int position;

    public Car() {
        this.position = 0;
    }

    public void movePosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
