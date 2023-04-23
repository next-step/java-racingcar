package race.domain;

public class Car {

    private final Name name;
    private final Position position;

    private static final int BOUND_NUMBER = 3;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int movingDistance) {
        this(new Name(name), new Position(movingDistance));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int input) {
        if (isOverThanThree(input)) {
            this.position.increase();
        }
    }

    public int getMovingDistance() {
        return this.position.getDistance();
    }

    public boolean isWinner(int maxDistance) {
        return this.position.isSame(maxDistance);
    }

    public String getName() {
        return this.name.get();
    }

    private boolean isOverThanThree(int input) {
        return input > BOUND_NUMBER;
    }
}
