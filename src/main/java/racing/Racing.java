package racing;

public class Racing {
    private final int count;
    private final Cars cars;

    public Racing(int movingCount, Cars cars) {
        this.count = movingCount;
        this.cars = cars;
    }

    public void start() {
        for (int i = 0; i < count; i++) {
            cars.move();
        }
    }
}
