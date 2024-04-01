package racingcar.domain;

import java.util.List;

public class CarRacing {
    private RunTimes runTimes;
    private RacingCars racingCars;

    public CarRacing(int times, String inputNames) throws Exception {
        this.runTimes = new RunTimes(times);
        this.racingCars = new RacingCars(inputNames);
    }

    public boolean isDuringGame() {
        return runTimes.isDuringGame();
    }

    public void decreaseRunTimes() {
        runTimes.decrease();
    }

    public List<Car> run() {
        return racingCars.roundRun();
    }
}
