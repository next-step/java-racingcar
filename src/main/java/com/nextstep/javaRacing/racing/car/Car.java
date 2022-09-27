package com.nextstep.javaRacing.racing.car;

public class Car implements Comparable<Car>{
    protected final String name;
    protected final MoveStrategy moveStrategy;
    protected int position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        this.position += moveStrategy.move();
    }

    public int getPosition(){
        return this.position;
    }

    public String printPosition(){
        return "-".repeat(this.position) + "|" + this.name;
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
