package racinggame.domain;

public class Car {

    private CarName carName;
    private Position position;
    private final int MIN_MOVEMENT_VALUE = 4;
    private final int NON_NEGATIVE_CHECK = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(int value) {
        if (value < NON_NEGATIVE_CHECK) {
            throw new IllegalArgumentException("음수는 입력 할 수 없습니다.");
        }

        if (value >= MIN_MOVEMENT_VALUE) {
            position = position.move();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
