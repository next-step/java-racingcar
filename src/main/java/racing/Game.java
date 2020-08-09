package racing;

import java.util.Random;

public class Game {

    public static final int RANDOM_MAX = 10;
    private Car[] cars;
    private int tryCount;

    public Game(int carCount, int tryCount) {
        this.cars = new Car[carCount];
        this.tryCount = tryCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    int getRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX);
    }
}
