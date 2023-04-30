package racing.vehicle;

public class Car implements Comparable<Car> {
    private final CarName name;
    private int position;
    private static final int DEFAULT_POSITION = 1;
    private final Engine engine;

    public Car(CarName name, Engine engine) {
        this.name = name;
        this.engine = engine;
        this.position = DEFAULT_POSITION;
    }

    public boolean isAt(int position) {
        return this.position == position;
    }

    public static Car createRandomCar(CarName name) {
        return new Car(name, new RandomEngine());
    }

    public void move() {
        this.position += engine.accelerate();
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car obj) {
        return Integer.compare(this.position, obj.position);

    }
}
