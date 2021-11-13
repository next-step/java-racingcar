package racinggame.domain;

import racinggame.view.ResultView;

public class RacingGame {

    private final Cars cars;
    private final Laps laps;
    private final CarStateGenerator carStateGenerator;

    public RacingGame(Integer carCount, Laps laps, CarStateGenerator carStateGenerator) {
        this.cars = Cars.from(carCount);
        this.laps = laps;
        this.carStateGenerator = carStateGenerator;
    }

    public void startRacing() {
        System.out.print("실행 결과");
        while (!laps.isGoal()) {
            cars.roundRacing(carStateGenerator);
            ResultView.currentRecord(cars);
            laps.passStartLine();
        }
    }
}
