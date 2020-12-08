package carracing.domain;

/**
 * 자동차 정보를 가지는 자동차 클래스
 */
public class Car {
    private static final int INITIATION_POSITION_NUMBER = 0;

    private final CarName name;
    private final CarPosition position;

    Car(CarName name) {
        this.name = name;
        this.position = new CarPosition(INITIATION_POSITION_NUMBER);
    }

    public void move(MovementPolicy movementPolicy) {
        if (movementPolicy.isMovable()) {
            position.move();
        }
    }

    public boolean isWon(int winningPositionNumber) {
        return winningPositionNumber == this.position.getNumber();
    }

    public CarPosition getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }
}
