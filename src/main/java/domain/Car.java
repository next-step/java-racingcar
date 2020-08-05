package domain;


import strategy.MovableStrategy;

public class Car {
    private String player;
    private int location;
    private MovableStrategy movableStrategy;

    public Car(String player, MovableStrategy movableStrategy) {
        this.player = player;
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

    public String getPlayer() {
        return player;
    }

    public int getLocation() {
        return location;
    }
}
