package step4;

public class Car implements Comparable<Car> {

    private final String name;

    private int location;

    private final MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
        this.name = name;
        this.location = 0;
        this.movableStrategy = movableStrategy;
    }

    public String name() {
        return this.name;
    }

    public int location() {
        return this.location;
    }

    public void moveOrStop() {
        if (this.movableStrategy.isMovable()) {
            this.location++;
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.location, o.location);
    }
}
