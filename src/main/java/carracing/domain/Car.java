package carracing.domain;

/**
 * 자동차 정보를 가지는 자동차 클래스
 */
public class Car {
    private final CarName name;
    private final CarPosition position;

    Car(CarName name) {
        this(name, new CarPosition());
    }

    private Car(CarName name, CarPosition position) {
        validate(name, position);
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

    private void validate(CarName name, CarPosition position) {
        if (name == null) {
            throw new IllegalArgumentException("자동차의 이름이 비어있습니다.");
        }
        if (position == null) {
            throw new IllegalArgumentException("자동차의 위치가 비어있습니다.");
        }
    }
}
