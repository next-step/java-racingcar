package car_racing;

import car_racing.move_strategy.RandomMoveStopStrategy;

import static car_racing.Cars.makeCars;

public class Track {
    private Cars cars;

    public Track(Integer carCount) {
        cars = makeCars(carCount, new RandomMoveStopStrategy());
    }

    public void run() {
        cars.move();
    }

    public Cars getCars() {
        return cars;
    }
}
