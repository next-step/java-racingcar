package study.carracing.domain;

import java.util.List;

public class Racing {

    private final RacingCars racingCars;

    public Racing() {
        racingCars = new RacingCars();
    }

    public void start(String[] carsName, int tryCount) {
        addRacingCars(carsName);
        move(tryCount);
    }

    private void addRacingCars(String[] carsName) {
        racingCars.addCar(carsName);
    }

    private void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCars.move();
        }
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }

    public List<String> winners() {
        Winners winners = new Winners();
        return winners.pickWinners(racingCars.getCars());
    }
}
