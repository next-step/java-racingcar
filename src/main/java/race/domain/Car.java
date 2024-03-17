package race.domain;

public class Car {

    private final Position position;
    private final Name name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this(new Position(position), new Name(name));
    }

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return this.position.getNumber();
    }

    public String getName() {
        return this.name.getName();
    }

    public void go() {
        this.position.increase();
    }

    public int maxComparedTo(int otherNumber) {
        return this.position.maxComparedTo(otherNumber);
    }

    public boolean isWinner(int maxNumber) {
        return this.position.isWinner(maxNumber);
    }

}
