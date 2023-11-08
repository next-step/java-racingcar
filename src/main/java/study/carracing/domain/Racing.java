package study.carracing.domain;

import java.util.List;

public class Racing {

    private final RacingCars racingCars;
    private Winners winners;

    public Racing() {
        racingCars = new RacingCars();
        winners = new Winners();
    }

    public void start(String[] carsName, int tryCount) {
        addRacingCars(carsName);
        move(tryCount);
        pickWinners();
    }

    private void addRacingCars(String[] carsName) {
        racingCars.addCar(carsName);
    }

    private void move(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCars.move();
        }
    }

    private void pickWinners() {
        winners.addNames(racingCars.getCars(), getMaxPosition());
    }

    private int getMaxPosition() {
        return racingCars.getMaxPosition();
    }

    public List<Car> getRacingCars() {
        return racingCars.getCars();
    }

    public List<String> getWinnersName() {
        return winners.getNames();
    }
}
