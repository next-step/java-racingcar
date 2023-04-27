package racing.vehicle;

public class Car {
    private int position;
    private static final int DEFAULT_POSITION = 1;

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.position = DEFAULT_POSITION;
    }

    public static Car createRandomCar() {
        return new Car(new RandomEngine());
    }

    public void move() {
        this.position += engine.accelerate();
    }

    public int getCurrentPosition() {
        return this.position;
    }
}
