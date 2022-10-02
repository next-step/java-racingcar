package com.game.racing.car;

import com.game.racing.position.Position;

public class Car {
    private final Position position;

    private final String name;

    public Car(String name) {
        this.position = new Position();
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        position.add();
    }
}
