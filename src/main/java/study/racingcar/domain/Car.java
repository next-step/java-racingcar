package study.racingcar.domain;

import study.racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.movable()){
            position.move();
        }
    }

    public String getName(){
        return name.getName();
    }

    public int getLocation(){
        return position.getLocation();
    }

    public int getMaxPosition(int maxPosition) {
        return position.getMaxPosition(maxPosition);
    }

    public boolean isWinnerPosition(int maxPosition) {
        return position.equals(new Position(maxPosition));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
