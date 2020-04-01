package racinggame.domain.car;

/**
 * 1. 움직이는 거리 필드
 * 1. 자동차 이름 필드
 * 1. 게임 진행시 자동차 이동
 * 1. 정렬
 */
public class Car implements Comparable<Car> {

    private static final int RACING_CAR_MOVING_BOUNDARY = 4;

    private final String carName;
    private final Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car moveCar(int num) {
        if (num >= RACING_CAR_MOVING_BOUNDARY) {
            return new Car(this.carName, this.position.move());
        }
        return this;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position.getPosition(), o.getPosition());
    }
}
