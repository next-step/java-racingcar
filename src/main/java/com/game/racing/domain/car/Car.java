package com.game.racing.domain.car;

import com.game.racing.domain.position.Position;

public class Car {

    private final Position position;
    private final CarName name;

    public Car(String name) {
        this.position = new Position(0);
        this.name = new CarName(name);
    }

    public Car(String name, Position position) {
        this.position = position;
        this.name = new CarName(name);
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getCarName();
    }

    public void move() {
        this.position.add();
    }

}
