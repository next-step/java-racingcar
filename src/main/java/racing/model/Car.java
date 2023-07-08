package racing.model;

import java.util.Random;

public class Car {

    private static final int DEFAULT_CRITERION = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int DEFAULT_BOUND = 10;

    private final CarName name;
    private final int criterion;
    private final int position;

    public Car(final String name) {
        this(new CarName(name), DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        this(new CarName(name), position);
    }

    private Car(final CarName name, final int position) {
        this.name = name;
        this.criterion = DEFAULT_CRITERION;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getCriterion() {
        return criterion;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinner(final int maxPosition) {
        return this.position == maxPosition;
    }

    public Car move(final Random random) {
        final int randomValue = random.nextInt(DEFAULT_BOUND);
        return move(randomValue);
    }

    private Car move(final int value) {
        if (canMove(value)) {
            return new Car(name, position + 1);
        }

        return this;
    }

    private boolean canMove(final int value) {
        return value >= this.criterion;
    }
}
