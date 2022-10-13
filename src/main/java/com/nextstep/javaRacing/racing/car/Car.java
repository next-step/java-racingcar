package com.nextstep.javaRacing.racing.car;

public class Car implements Comparable<Car>{

    private final Name name;
    private final MoveStrategy moveStrategy;
    private Position position;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this(name, moveStrategy, 0);
    }

    public Car(final String name, final MoveStrategy moveStrategy, final int position) {
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
        this.position = new Position(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition(){
        return this.position.get();
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            this.position.move();
        }
    }

    public boolean hasSamePosition(final Car compareCar) {
        return this.position.equals(compareCar.position);
    }

    @Override
    public String toString(){
        return String.format("car{name=%s, position=%s}",this.name, this.position.get());
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position.get(), o.position.get());
    }
}
