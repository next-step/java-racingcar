package racingcar.domain;

public class Car {

    private Position position;
    private String name;
    private MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy, String name) {
        validateName(name);
        this.movableStrategy = movableStrategy;
        this.name = name.trim();
        this.position = new Position();
    }

    private void validateName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다");
        }
    }

    public int moveIfPossible() {
        if (movableStrategy.isMovable()) {
            position = position.increase();
        }
        return position.getPosition();
    }

    public int getMaxPosition(int maxPosition) {
        if (maxPosition < position.getPosition()) {
            return position.getPosition();
        }
        return maxPosition;
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == position.getPosition();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }
}
