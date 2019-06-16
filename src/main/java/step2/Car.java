package step2;

public class Car {
    private final Integer carNo;
    private final Integer position;

    public Car(Integer carNo, Integer position) {
        this.carNo = carNo;
        this.position = position;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public Integer getPosition() {
        return position;
    }

    public Car move() {
        if (RacingGameRandomUtils.isMove()) {
            return new Car(this.getCarNo(), this.getPosition() + 1);
        }
        return this;
    }

}
