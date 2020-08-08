package domain;


import strategy.MovableStrategy;

public class Car {
    private final String player;
    private int location;
    private final MovableStrategy movableStrategy;

    public Car(String player, int location, MovableStrategy movableStrategy) {
        this.player = player;
        this.location = location;
        this.movableStrategy = movableStrategy;
    }

    public static Car of(String player, MovableStrategy movableStrategy) {
        return new Car(player, 0, movableStrategy);
    }

    public static Car locationOf(String player, int location, MovableStrategy movableStrategy) {
        return new Car(player, location, movableStrategy);
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
