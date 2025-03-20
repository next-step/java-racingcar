package racing.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private static final int INIT_POSITION = 1;

    private final String name;
    private final int position;


    public Car(String name) {
        checkNameIsPossible(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MOVE_CONDITION) {
            return new Car(this.name, this.position + 1);
        }
        return this;
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
