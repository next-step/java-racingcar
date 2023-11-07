package study.carracing.domain;

import java.util.List;

public class Racing {

    private RacingCars racingCars;

    public Racing() {
        racingCars = new RacingCars();
    }

    public void start(int carCount, int tryCount) {
        addRacingCars(carCount);
        move(tryCount);
    }

    private void addRacingCars(int carCount) {
        racingCars.addCar(carCount);
    }

    private void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCars.move();
        }
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }
}
