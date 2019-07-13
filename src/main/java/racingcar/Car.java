package racingcar;

public class Car {
    private static final int RULE_OF_MOVE = 4;
    private static final int INIT_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, INIT_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= RULE_OF_MOVE)
            this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
