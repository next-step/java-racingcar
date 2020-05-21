package step5.domain;

public class Car {

    private int position;
    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public Trace move(MovingStrategy strategy) {
        if (strategy.canMove()) {
            this.position++;
        }
        return new Trace(this.name, this.position);
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public int getPosition() {
        return position;
    }
}
