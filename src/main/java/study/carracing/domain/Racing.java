package study.carracing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final RacingCars racingCars;

    private History history;

    public Racing() {
        racingCars = new RacingCars();
        history = new History();
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
            history.addScores(racingCars);
        }
    }

    public History getHistory() {
        return history;
    }

    public List<String> winners() {
        Winners winners = new Winners();
        return winners.pickWinners(racingCars.getCars());
    }
}
