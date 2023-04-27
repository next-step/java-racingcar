package racing.vehicle;

public class Car {
    private int position;
    private static final int DEFAULT_POSITION = 1;
    private static final String UNIT_DISPLAYING_LABS = "-";

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.position = DEFAULT_POSITION;
    }

    public void move() {
        this.position += engine.accelerate();
    }

    public int getCurrentPosition() {
        return this.position;
    }
}
