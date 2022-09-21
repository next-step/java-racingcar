package com.nextstep.javaRacing;

public class RaceCar implements Car {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public RaceCar(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void move() {
        int distance = moveStrategy.move();
        position += distance;
    }
}
