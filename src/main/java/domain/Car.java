package domain;


import Strategy.MovableStrategy;

public class Car {
    private int location;
    private MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.location = 0;
        this.movableStrategy = movableStrategy;
    }

    public Car(int location, MovableStrategy movableStrategy) {
        this.location = location;
        this.movableStrategy = movableStrategy;
    }

    public void move(int randomNumber) {
        if (movableStrategy.move(randomNumber)) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
