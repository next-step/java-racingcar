package racing;

public class Game {

    private Car[] cars;
    private int tryCount;
    private racing.Random random;

    public Game(int carCount, int tryCount, racing.Random random) {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }

        this.tryCount = tryCount;
        this.random = random;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void play() {
        for (Car car : cars) {
            if (random.getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

}
