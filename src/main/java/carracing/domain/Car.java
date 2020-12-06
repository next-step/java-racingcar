package carracing.domain;

/**
 * 자동차 정보를 가지는 자동차 클래스
 */
class Car {
    private final CarPosition position;

    Car(CarPosition position) {
        validateCar(position);
        this.position = position;
    }

    private void validateCar(CarPosition position) {
        if (position == null) {
            throw new IllegalArgumentException("자동차를 구성하는 위치가 입력되어야합니다.");
        }
    }

    public CarPosition getPosition() {
        return position;
    }
}
