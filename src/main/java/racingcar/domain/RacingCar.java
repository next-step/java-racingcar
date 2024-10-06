package racingcar.domain;

import racingcar.domain.movableStrategy.MovableStrategy;

import java.util.Objects;

public class RacingCar {
    private final CarName name;
    private final CarNo carNo;
    private Position position;

    private RacingCar(CarName name, CarNo carNo) {
        this.name = name;
        this.carNo = carNo;
        this.position = Position.valueOfInitialPosition();
    }

    public static RacingCar valueOf(String name, int carNo) {
        return new RacingCar(CarName.valueOf(name), CarNo.valueOf(carNo));
    }

    public void race(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position = this.position.move();
        }
    }

    public String getName() {
        return this.name.value();
    }

    public int getCarNo() {
        return this.carNo.value();
    }

    public int getPosition() {
        return this.position.value();
    }

    public boolean isSamePosition(int position) {
        return this.position.isSamePosition(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carNo == racingCar.carNo && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carNo);
    }
}
