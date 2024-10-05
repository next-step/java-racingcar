package racingcar;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int maxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }
}
