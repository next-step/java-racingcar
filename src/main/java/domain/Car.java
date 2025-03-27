package domain;

public class Car {
    private static final int MOVE_THRS = 4;
    private final Position position = new Position(0);
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= MOVE_THRS) {
            this.position.increase();
        }
    }

    public String getName() {
        return this.name.toString();
    }

    public Position getPosition() {
        return this.position;
    }

    public String getPositionToString() {
        return this.position.toString();
    }
}