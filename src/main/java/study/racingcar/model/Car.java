package study.racingcar.model;


import study.racingcar.strategy.RandomMoveStrategy;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(Name name) {
        this(name, new Position(START_POSITION));
    }

    public Car(String name, Position position) {
        this(new Name(name), position);
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(){
        if(new RandomMoveStrategy().movable()){
            position.move();
        }
    }

    public String getName(){
        return name.getName();
    }

    public String getLocation(){
        return position.getLocation();
    }

    public int getMaxPosition(int maxPosition) {
        int carPosition = position.getLocation().length();
        if (maxPosition < carPosition){
            return carPosition;
        }
        return maxPosition;
    }

    public boolean isWinnerPosition(int maxPosition) {
        if(getLocation().length() == maxPosition){
            return true;
        }
        return false;
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
