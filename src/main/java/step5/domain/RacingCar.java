package step5.domain;

import step5.common.CarName;
import step5.common.CarNumber;
import step5.common.Position;
import step5.common.Positive;
import step5.strategy.MovableStrategy;
import step5.strategy.RandomMovableStrategy;

import static step5.common.Constant.EMPTY_STRING;
import static step5.common.Constant.NATURAL_FIRST;

public class RacingCar implements Comparable<RacingCar> {

    private final CarNumber number;

    private final CarName name;

    private Position position;

    public RacingCar() {
        this(NATURAL_FIRST);
    }

    public RacingCar(int number) {
        this(number, EMPTY_STRING);
    }

    public RacingCar(int number, String name) {
        this (number, name, NATURAL_FIRST);
    }

    public RacingCar(int number, String name, int position) {
        this.number = new CarNumber(number);
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public void raceCar() {
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        move(movableStrategy);
    }

    private void setForwardPosition() {
        Positive p = position.plusOne();
        this.position = new Position(p.positive());
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) setForwardPosition();
    }

    public int number() {
        return number.positive();
    }

    public String name() {
        return name.name();
    }

    public int position() {
        return position.positive();
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof RacingCar && this.number() == ((RacingCar) o).number();
    }

    @Override
    public int hashCode() {
        return number() * 13;
    }

    @Override
    public int compareTo(RacingCar o) {
        return position() - o.position();
    }
}
