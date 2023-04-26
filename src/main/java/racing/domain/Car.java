package racing.domain;

public class Car {

    private static final Integer MOVE_MIN = 4;

    private final Name name;
    private Position position;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = new Name(name);
        this.position = new Position();
        this.numberGenerator = numberGenerator;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move() {
        if (numberGenerator.generate() >= MOVE_MIN) {
            this.position = position.move();
        }
    }

    public boolean isLocatedAt(Position maxPosition) {
        return this.position.isSameWith(maxPosition);
    }

    public Position position() {
        return position;
    }

    public Name name() {
        return name;
    }
}
