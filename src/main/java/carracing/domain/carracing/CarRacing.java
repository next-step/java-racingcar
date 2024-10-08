package carracing.domain.carracing;

import carracing.view.ResultView;

public class CarRacing {
    private final Cars cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;

    public CarRacing(String[] carNames, int moveTryCount) {
        this.cars = Cars.create(carNames);
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = new CarsMoveStatusHistory();
    }

    public void start() {
        for (int i = 0; i < this.moveTryCount; i++) {
            this.cars.move();
            this.carsMoveStatusHistory.save(this.cars);
        }
        ResultView.printCarRacingResult(this.carsMoveStatusHistory);
        ResultView.printCarRacingWinners(this.cars.winnersNames());
    }

    public Cars getCars() {
        return cars;
    }

    public int getMoveTryCount() {
        return moveTryCount;
    }
    public CarsMoveStatusHistory getCarsMoveStatusHistory() {
        return carsMoveStatusHistory;
    }
}
