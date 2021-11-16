package racinggame.controller;

import racinggame.domain.CarStateGenerator;
import racinggame.domain.Cars;
import racinggame.domain.Laps;
import racinggame.domain.Names;
import racinggame.view.ResultView;

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
            cars.roundRacing(carStateGenerator);
            ResultView.currentRecord(cars);
            laps.passStartLine();
        }
    }

    public Names findWinner() {
        return cars.findWinners();
    }
}
