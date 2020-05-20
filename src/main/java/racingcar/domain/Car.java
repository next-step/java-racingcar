package racingcar.domain;

public class Car {
    private static final int MOVABLE_CONDITION = 4;
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(Strategy strategy) {
        if (isMove(strategy)) {
            position++;
        }
    }

    private boolean isMove(Strategy strategy) {
        return strategy.getNumber() >= MOVABLE_CONDITION;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
