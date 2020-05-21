package step3.racingcar;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;
    private final String name;
    private final MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.position = DEFAULT_POSITION;
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    public void move() {
        boolean isMovable = this.movingStrategy.isMovable();
        if (isMovable == true)
            this.position++;
    }
}
