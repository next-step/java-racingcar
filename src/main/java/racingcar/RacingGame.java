package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingGame {
    private CarGroup cars;
    private int currTry;
    private int maxTry;

    public RacingGame(CarGroup cars, int tryNum) {
        this.cars = cars;

        this.currTry = 0;
        this.maxTry = tryNum;
    }

    public boolean checkNotGameOver() {
        return this.currTry < this.maxTry;
    }

    public void printCars(Consumer<Car> printMethod) {
        this.cars.getCarStream()
                .forEach(printMethod);
    }

    public List<Car> getWinners() {
        return this.cars.getCarStream()
                .collect(
                        Collectors.groupingBy(Car::getPosition)
                ).entrySet()
                .stream()
                .max(
                        Comparator.comparing(Map.Entry::getKey)
                ).get()
                .getValue();
    }

    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currTry++;
        int carNum = this.cars.getCarNum();
        for (int carIdx = 0; carIdx < carNum; carIdx++) {
            this.cars.moveCar(carIdx);
        }
    }
}
