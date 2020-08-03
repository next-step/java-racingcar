package racingcar;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveAndStop(Fuel fuel) {

        if (isMoveCondition(fuel.getAsInt())) {
            moveCount++;
        }
    }

    private boolean isMoveCondition(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}