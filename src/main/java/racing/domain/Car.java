package racing.domain;

public class Car {

    private int position = 1;

    public int moveForward() {
        return ++position;
    }

    public int getPosition() {
        return position;
    }
}
