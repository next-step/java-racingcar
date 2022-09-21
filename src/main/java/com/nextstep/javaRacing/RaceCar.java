package com.nextstep.javaRacing;

public class RaceCar implements Car{
    private String name;
    private Position position;
    private MoveStrategy moveStrategy;

    public RaceCar(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.position = new Position(name);
    }

    public void move(){
        int distance = moveStrategy.move();
        position.add(distance);
    }

    public Position position(){
        return position;
    }
}
