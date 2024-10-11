package carracing.domain.carracing;

import carracing.domain.carracing.dto.CarsMoveStatusHistory;
import carracing.domain.carracing.dto.MoveStrategy;

import java.util.List;

public class CarRacing {
    private final Cars cars;
    private final int moveTryCount;
    private final CarsMoveStatusHistory carsMoveStatusHistory;
    private final MoveStrategy moveStrategy;

    public CarRacing(String[] carNames, int moveTryCount, MoveStrategy moveStrategy) {
        this.cars = Cars.create(carNames);
        this.moveTryCount = moveTryCount;
        this.carsMoveStatusHistory = new CarsMoveStatusHistory();
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        for (int i = 0; i < this.moveTryCount; i++) {
            this.cars.move(moveStrategy);
            this.carsMoveStatusHistory.save(this.cars);
        }
    }

    public int getMoveTryCount() {
        return moveTryCount;
    }

    public CarsMoveStatusHistory getCarsMoveStatusHistory() {
        return carsMoveStatusHistory;
    }

    public List<String> winnersNames() {
        return cars.winnersNames();
    }
}
