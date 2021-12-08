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

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MovementPolicy movementPolicy) {
        if (movementPolicy.isMovable()) {
            return new Car(this.name, position.move());
        }
        return this;
    }

    public boolean isWon(int winningPositionNumber) {
        return position.isSameWith(winningPositionNumber);
    }

    public CarPosition getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
