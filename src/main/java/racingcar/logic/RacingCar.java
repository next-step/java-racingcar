package racingcar.logic;

import racingcar.logic.movableStrategy.MovableStrategy;

import java.util.Objects;

public class RacingCar {
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private final int carNo;
    private int position;

    private RacingCar(String name, int carNo) {
        this.name = name;
        this.carNo = carNo;
        this.position = INITIAL_POSITION;
    }

    public static RacingCar valueOf(String name, int carNo) {
        return new RacingCar(name, carNo);
    }

    public void race(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getCarNo() {
        return this.carNo;
    }

    public int getPosition() {
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
