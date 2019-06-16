package racingcar.model;

public class Car {

    private int position;

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + '}';
    }
}
