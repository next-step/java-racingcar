package step5.racingcar.domain;

public class Car {

    private int position;
    private final String name;

    private static final int DEFAULT_POSITION = 0;

    public Car(String name) {
        this.position = DEFAULT_POSITION;
        this.name = name;
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    public void move(MovingStrategy movingStrategy) {
        boolean isMovable = movingStrategy.isMovable();
        if (isMovable == true)
            position++;
    }
}
