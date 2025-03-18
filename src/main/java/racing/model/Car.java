package racing.model;

public class Car {
    private static final int MOVE_CONDITION = 4;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final int position;

    public Car(String name, int position) {
        checkNameIsPossible(name);
        this.name = name;
        this.position = position;
    }

    public Car moved(int number) {
        if (canMove(number)) {
            return move();
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }

    private Car move() {
        return new Car(this.name, this.position + 1);
    }

    private void checkNameIsPossible(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(name + " is over " + MAX_NAME_LENGTH + " letters");
        }
    }
}
