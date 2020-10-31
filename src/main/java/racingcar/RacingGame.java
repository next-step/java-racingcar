package racingcar;

import java.util.function.Consumer;

public class RacingGame {
    private CarCollection collection;
    private int currTry;
    private int maxTry;

    public RacingGame(CarCollection carCollection, int tryNum) {
        this.collection = carCollection;

        this.currTry = 0;
        this.maxTry = tryNum;
    }

    public boolean checkNotGameOver() {
        return this.currTry < this.maxTry;
    }

    public void printCars(Consumer<Car> printMethod) {
        this.collection.print(printMethod);
    }

    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currTry++;
        int carNum = this.collection.getCarNum();
        for (int carIdx = 0; carIdx < carNum; carIdx++) {
            this.collection.moveCar(carIdx);
        }
    }
}
