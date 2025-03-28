package step4.domain;

import java.util.Comparator;

public class Car {
    private final String carName;
    private Position position;
    public static final int DEFAULT_POSITION = 0;

    public Car(String carName) {
        this.carName = carName;
        this.position = new Position(DEFAULT_POSITION);
    }

    public String getCarName() { return  this.carName; }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(MoveStrategy moveStrategy) {
        if (!moveStrategy.isMovable()) return;
        this.position.move();
    }

    public static final Comparator<Car> POSITION_COMPARATOR = Comparator.comparingInt(Car::getPosition);

}
