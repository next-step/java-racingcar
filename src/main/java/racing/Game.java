package racing;

public class Game {

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
}
