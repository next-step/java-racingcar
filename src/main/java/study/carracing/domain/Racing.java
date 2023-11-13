package study.carracing.domain;

import study.carracing.util.MoveStrategy;

import java.util.List;

public class Racing {

    private final MoveStrategy moveStrategy;
    private final RacingCars racingCars;
    private final History history;

    public Racing(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.racingCars = new RacingCars();
        this.history = new History();
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
            racingCars.move(moveStrategy);
            history.addScores(racingCars);
        }
    }

    public List<String> racingHistory() {
        return history.getScores();
    }

    public List<String> winners() {
        Winners winners = new Winners();
        return winners.pickWinners(racingCars.getCars());
    }
}
