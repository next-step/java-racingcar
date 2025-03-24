package domain;

public class Car {
    private static final int MOVE_THRS = 4;
    private final Position position = new Position(0);
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= MOVE_THRS) {
            this.position.increase();
        }
    }

    public String getName() {
        return this.name;
    }

    public Position getCurrentPosition() {
        return this.position;
    }
}