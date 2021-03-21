package step4.domain;

import step4.strategy.MovableStrategy;

public class Car {
    private static final int INITIAL_POSITION_NUM = 0;

    private final Name name;
    private int position;

    private Car(final String name) {
        this(new Name(name), INITIAL_POSITION_NUM);
    }

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public void move(MovableStrategy strategy) {
        if (strategy.movable()) {
            plusPosition();
        }
    }

    public boolean isWinner(int winnerPosition) {
        if (this.position == winnerPosition) {
            return true;
        }
        return false;
    }

    private void plusPosition() {
        this.position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
