package step4;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final Engine engine;
    private final String name;
    private int position;

    private Car(Engine engine, String name, int position) {
        this.engine = engine;
        this.name = name;
        this.position = position;
    }

    public static Car of(Engine engine, String name) {
        return new Car(engine, name, DEFAULT_POSITION);
    }

    public void move() {
        if (engine.canStart()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
