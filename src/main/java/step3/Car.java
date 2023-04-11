package step3;

public class Car {

    private final Engine engine;
    private int position;

    public Car(Engine engine) {
        this.engine = engine;
        this.position = 0;
    }

    public void move() {
        if (engine.isOk()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
