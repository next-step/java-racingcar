package racingcar.model;

import java.util.List;

public class RacingCar {

    private int time;
    private Cars cars;

    public static RacingCar generate(int time, int carCount) {
        return new RacingCar(time, Cars.generate(carCount));
    }

    RacingCar(int time, Cars cars) {
        this.time = time;
        this.cars = cars;
    }

    public List<Car> racing() {
        time--;
        return cars.moveAll();
    }

    public boolean isGameOver() {
        return time == 0;
    }


    public List<Car> getResult() {
        return cars.getCars();
    }
}
