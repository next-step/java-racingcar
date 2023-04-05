package racingcar;

public class Car {

    private int position = 0;

    public Car() {
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }

    public int getPosition() {
        return this.position;
    }
}
