package racinggame.domain.history;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;

public class RoundHistories {

    private final List<RoundHistory> allRoundHistory = new ArrayList<>();


    public void captureRoundHistory(final Cars cars) {
        List<CarHistory> carHistories = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carHistories.add(new CarHistory(car));
        }
        allRoundHistory.add(new RoundHistory(carHistories));

    }

    public List<RoundHistory> getAllRoundHistory() {
        return new ArrayList<>(allRoundHistory);
    }
}
