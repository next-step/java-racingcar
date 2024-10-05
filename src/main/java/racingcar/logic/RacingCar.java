package racingcar.logic;

import racingcar.logic.movableStrategy.MovableStrategy;

import java.util.Objects;

public class RacingCar {
    private static final int INITIAL_POSITION = 0;

    private final CarName name;
    private final int carNo;
    private Position position;

    private RacingCar(CarName name, int carNo) {
        this.name = name;
        this.carNo = carNo;
        this.position = Position.valueOf(INITIAL_POSITION);
    }

    public static RacingCar valueOf(String name, int carNo) {
        return new RacingCar(CarName.valueOf(name), carNo);
    }

    public void race(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position = this.position.move();
        }
    }

    public String getName() {
        return this.name.getCarName();
    }

    public int getCarNo() {
        return this.carNo;
    }

    public Position getPosition() {
        return this.position;
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
