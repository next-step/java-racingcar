package racinggame.controller;

import racinggame.domain.*;
import racinggame.dto.RoundLogs;
import racinggame.view.ResultView;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Laps laps;
    private final CarStateGenerator carStateGenerator;

    public RacingGame(Names names, Laps laps, CarStateGenerator carStateGenerator) {
        this.cars = Cars.from(names);
        this.laps = laps;
        this.carStateGenerator = carStateGenerator;
    }

    public void startRacing() {
        System.out.print("\n실행 결과");
        while (!laps.isGoal()) {
            List<Car> currentRecord = cars.roundRacing(carStateGenerator);
            RoundLogs roundLogs = new RoundLogs(currentRecord);
            ResultView.currentRecord(roundLogs);
            laps.passStartLine();
        }
    }

    public Names findWinner() {
        return cars.findWinners();
    }
}
