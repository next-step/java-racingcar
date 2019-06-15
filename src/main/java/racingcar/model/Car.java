package racingcar.model;

public class Car {

    private int position = 1;

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
