package car.entity;

import car.util.PrintGameStatus;
import car.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<Car> racingCars;
    private int tryCount;

    public RacingGame(int carCount, int tryCount) {
        this.racingCars = setCars(carCount);
        this.tryCount = tryCount;
    }

    public List<Car> setCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        int i=0;

        while (i < carCount) {
            cars.add(new Car());
            i++;
        }
        return cars;
    }

    public void gameStart(int tryCount) {
        int i = 0;

        while (i < tryCount) {
            this.racingCars = playingGame(racingCars);
            PrintGameStatus.carsStatus(this.racingCars);
            i ++;
        }
    }

    private List<Car> playingGame(List<Car> cars) {
        for (Car aCar : cars) {
            aCar.move(RandomNumber.getNumber());
        }
        return cars;
    }
}
