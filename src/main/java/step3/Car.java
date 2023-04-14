package step3;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final Engine engine;
    private int position;

    private Car(Engine engine, int position) {
        this.engine = engine;
        this.position = position;
    }

    public static Car of(Engine engine) {
        return new Car(engine, DEFAULT_POSITION);
    }

    public void move() {
        if (engine.canStart()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
