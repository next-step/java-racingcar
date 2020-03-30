package racing.domain;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private int position;

    public Car() {
        position = DEFAULT_POSITION;
    }


    public Car(String name, int inputPosition) {
        position = inputPosition;
    }

    public Car(String name) {

    }

    public int moveByCondition(int condition) {
        if (Movable.isMovable(condition)) {
            return moveForward();
        }

        return position;
    }

    private int moveForward() {
        return ++position;
    }

    public Car copy() {
        return new Car("", position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return new String();
    }

    public boolean isSameName(String input) {
        return false;
    }
}