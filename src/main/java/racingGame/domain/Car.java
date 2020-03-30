package racingGame.domain;

public class Car {
    private final int MOVE_CONDITION = 4;
    String name;
    int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar() {
        this.position++;
    }
}
