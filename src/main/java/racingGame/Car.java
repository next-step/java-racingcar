package racingGame;

public class Car {

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(Position position) {
        return new Car(this.name, position.canMove() ? this.position + 1 : this.position);
    }

    public String getName() { return name; }
    public int getPosition() { return position; }
}
