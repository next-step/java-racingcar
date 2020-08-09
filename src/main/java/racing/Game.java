package racing;

import racing.view.ResultView;

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

    void play() {
        for (Car car : cars) {
            if (random.getRandomNumber() >= 4) {
                car.move();
            }
        }

        ResultView.print(cars);
    }

    public void playAll() {
        for (int i = 0; i < tryCount; i++) {
            play();
        }
    }

}
