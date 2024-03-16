package racingcar.domain;

public class Car implements Vehicle {
    private final int MOVABLE_NUMBER = 4;
    private final Name name;
    private Integer moveCount = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public Integer getMoveCount() {
        return moveCount;
    }

    @Override
    public void move(int number) {
        if (isMovable(number)) {
            moveCount++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER;
    }


}
