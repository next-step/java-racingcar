package domain;

public class Car {
    private static final int MOVE_THRS = 4;
    private final Position position = new Position();

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= MOVE_THRS) {
            this.position.increase();
        }
    }

    public Position getCurrentPosition() {
        return this.position;
    }
}