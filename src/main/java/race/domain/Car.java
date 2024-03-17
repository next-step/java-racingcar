package race.domain;

public class Car {

    private static final int FORWARD_STANDARD = 4;
    private Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public boolean canForward(int random) {
        return random >= FORWARD_STANDARD;
    }

    public void makeForward(int random) {
        if (canForward(random)) {
            position.move();
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
