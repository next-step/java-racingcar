package study.carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final RacingCars racingCars;
    private List<String> winners;

    public Racing() {
        racingCars = new RacingCars();
    }

    public void start(String[] carsName, int tryCount) {
        addRacingCars(carsName);
        move(tryCount);
        findWinners();
    }

    private void addRacingCars(String[] carsName) {
        racingCars.addCar(carsName);
    }

    private void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCars.move();
        }
    }

    private void findWinners() {
        final int maxPosition = getMaxPosition();
        addWinners(maxPosition);
    }

    private void addWinners(int maxPosition) {
        winners = new ArrayList<>();
        winners.addAll(
                getRacingCars().stream()
                        .filter(car -> car.getPosition() == maxPosition)
                        .map(Car::getName)
                        .collect(Collectors.toList())
        );
    }

    private int getMaxPosition() {
        return racingCars.getMaxPosition();
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }

    public List<String> getWinners() {
        return winners;
    }
}
