package racingcar;

public class Car {

    private int move = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int distance) {
        move += distance;
    }

    public int getMovingDistance() {
        return move;
    }

    public String getName() {
        return name;
    }
}
