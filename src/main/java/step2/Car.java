package step2;

public class Car {
    private static final int STARTING_POINT = 0;

    private final Integer carNo;
    private final Integer position;
    private final MoveStrategy moveStrategy;

    public Car(Car car) {
        this(car.carNo, car.position, car.moveStrategy);
    }

    public Car(Integer carNo, MoveStrategy moveStrategy) {
        this(carNo, STARTING_POINT, moveStrategy);
    }

    private Car(Integer carNo, Integer position, MoveStrategy moveStrategy) {
        this.carNo = carNo;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public Integer getPosition() {
        return position;
    }

    public Car move() {
        if (moveStrategy.isMove()) {
            return new Car(carNo, position + moveStrategy.getMoveSize(), moveStrategy);
        }
        return new Car(carNo, position, moveStrategy);
    }

}
