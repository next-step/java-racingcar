package RacingCar;

import static RacingCar.RacingCar.random;

public class Car {
    private final int name;
    private int position;

    public Car(int name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        int result = random();

        if (result >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
