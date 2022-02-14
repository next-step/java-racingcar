package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarMoveHistory {

    private final List<CarMoveTurnHistory> carMoveHistory;

    private CarMoveHistory() {
        carMoveHistory = new ArrayList<>();
    }

    public static CarMoveHistory create() {
        return new CarMoveHistory();
    }

    public List<CarMoveTurnHistory> getCarMoveHistory() {
        return carMoveHistory;
    }

    public void add(CarMoveTurnHistory carMoveTurnHistory) {
        carMoveHistory.add(carMoveTurnHistory);
    }
}
