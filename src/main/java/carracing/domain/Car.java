package carracing.domain;

/**
 * 자동차 정보를 가지는 자동차 클래스
 */
public class Car {
    private final CarName name;
    private final CarPosition position;

    Car(CarName name) {
        validate(name);
        this.name = name;
        this.position = new CarPosition();
    }

    private void validate(CarName name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    public void move(MovementPolicy movementPolicy) {
        if (movementPolicy.isMovable()) {
            position.move();
        }
    }

    public boolean isWon(int winningPositionNumber) {
        return position.isSameWith(winningPositionNumber);
    }

    public CarPosition getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }
}
