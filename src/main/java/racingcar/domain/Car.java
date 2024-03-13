package racingcar.domain;

public class Car implements Vehicle {
    private final int MOVABLE_NUMBER = 4;
    private final int MAX_NAME_SIZE = 5;

    private String name;
    private Integer moveCount = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new RuntimeException("자동차 이름은 5자를 초과 할 수 없습니다.");
        }
    }
}
