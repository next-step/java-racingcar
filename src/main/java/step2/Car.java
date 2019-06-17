package step2;

public class Car {
    private final Integer carNo;
    private final Integer position;
    private final MoveStrategy moveStrategy;

    public Car(Integer carNo, Integer position) {
        this.carNo = carNo;
        this.position = position;
        this.moveStrategy = new DefaultMoveStrategy();
    }

    public Car(Integer carNo, Integer position, MoveStrategy moveStrategy) {
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
            return new Car(this.getCarNo(), this.getPosition() + 1, moveStrategy);
        }
        return this;
    }

}
