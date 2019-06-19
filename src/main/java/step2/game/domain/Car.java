package step2.game.domain;

public class Car {
    private static final int STARTING_POINT = 0;

    private final Integer carNo;
    private final CarName carName;
    private final Integer position;
    private final MoveStrategy moveStrategy;

    public Car(Car car) {
        this(car.carNo, car.carName, car.position, car.moveStrategy);
    }

    public Car(Integer carNo, CarName carName, MoveStrategy moveStrategy) {
        this(carNo, carName, STARTING_POINT, moveStrategy);
    }

    private Car(Integer carNo, CarName carName, Integer position, MoveStrategy moveStrategy) {
        this.carNo = carNo;
        this.carName = carName;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public int getCarNo() {
        return carNo;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public Car move() {
        if (moveStrategy.isMove()) {
            return new Car(carNo, carName, position + 1, moveStrategy);
        }
        return new Car(carNo, carName, position, moveStrategy);
    }

}
