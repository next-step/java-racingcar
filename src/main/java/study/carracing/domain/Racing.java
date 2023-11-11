package study.carracing.domain;

import java.util.List;
import java.util.stream.Collectors;

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
        return racingCars.getCars().stream().collect(Collectors.toUnmodifiableList());
    }

    public List<String> winners() {
        Winners winners = new Winners();
        return winners.pickWinners(racingCars.getCars()).stream().collect(Collectors.toUnmodifiableList());
    }
}
