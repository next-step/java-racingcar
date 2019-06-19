package step3.game.domain;

public class Car {
    private static final int STARTING_POINT = 0;

    private final Integer carNo;
    private final CarName carName;
    private final Integer position;

    public Car(Car car) {
        this(car.carNo, car.carName, car.position);
    }

    public Car(Integer carNo, CarName carName) {
        this(carNo, carName, STARTING_POINT);
    }

    private Car(Integer carNo, CarName carName, Integer position) {
        this.carNo = carNo;
        this.carName = carName;
        this.position = position;
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

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            return new Car(carNo, carName, position + 1);
        }
        return new Car(this);
    }

}
