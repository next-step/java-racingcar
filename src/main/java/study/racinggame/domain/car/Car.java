package study.racinggame.domain.car;

public class Car {
    private final Name name;
    private int position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public String name() {
        return name.getValue();
    }

    public boolean isWinner(int max) {
        return this.position == max;
    }

    public int getPosition() {
        return position;
    }
}
