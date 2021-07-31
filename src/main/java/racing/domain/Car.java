package racing.domain;

public class Car {

    private static final int LOWER_BOUND = 4;
    private static final int UPPER_BOUND = 9;

    private Position position;
    private Name name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public void move(int number) {
        if (number >= LOWER_BOUND && number <= UPPER_BOUND) {
            this.position = position.add(1);
        }
    }

    public int getNowPosition() {
        return this.position.getPos();
    }

    public String getName() {
        return name.getName();
    }
}
