package racing.model;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
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

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }

    private Car move() {
        return new Car(this.name, this.position + 1);
    }

    public String getName() {
        return name;
    }

    private void checkNameIsPossible(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(name + " is over " + MAX_NAME_LENGTH + " letters");
        }
    }

    public int getPosition() {
        return position;
    }
}
