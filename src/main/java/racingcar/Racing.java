package racingcar;

import java.util.*;

public class Racing {

    private final int gameCount;
    private final Cars cars;
    private final RaceResult raceResult;


    public Racing(List<String> carNames, int gameCount) {
        this.gameCount = gameCount;
        this.cars = new Cars(carNames);
        this.raceResult = new RaceResult();
    }

    public void race() {
        for (int i = 0; i < gameCount; i++) {
            game();
            record();
        }
    }

    private void game() {
        cars.move();
    }

    private void record() {
        raceResult.record(cars);
    }

    public List<RaceRecord> getRaceRecords() {
        return raceResult.getRaceRecord();
    }

    public List<Car> getWinner(){
        return cars.getWinner();
    }
}
