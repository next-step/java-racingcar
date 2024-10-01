package race;

import java.util.UUID;

public class Car {
    private UUID id;
    private int step;

    private Car() {
        this.id = UUID.randomUUID();
        this.step = 0;
    }

    public void move() {
        this.step++;
    }

    public UUID getId() {
        return this.id;
    }

    public int getCurrentStep() {
        return this.step;
    }

    public static Car create() {
        return new Car();
    }

    public static Car[] create(int count) {
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = Car.create();
        }

        return cars;
    }
}
