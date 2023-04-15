package racing;

import java.util.Random;

public class Car {
    private int location;

    Car() {
    }

    Car(int location) {
        this.location = location;
    }

    public Car move() {
        this.location += makeRandomPower();
        return new Car(this.location);
    }

    static private int makeRandomPower() {
        Random random = new Random();
        int randomPower = random.nextInt(8) + 1; // 1~8
        return (randomPower >= 4) ? randomPower : 0;
    }

    public int getLocation() {
        return this.location;
    }
}
