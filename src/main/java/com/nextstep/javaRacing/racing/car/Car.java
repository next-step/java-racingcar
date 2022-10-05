package com.nextstep.javaRacing.racing.car;

public class Car implements Comparable<Car>{

    private final CarName name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new CarName(name);
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition(){
        return this.position;
    }

    public boolean hasSamePosition(int comparePosition) {
        return this.position == comparePosition;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            this.position += 1;
        }
    }

    @Override
    public String toString(){
        return String.format("car{name=%s, position=%s}",this.name, this.position);
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
