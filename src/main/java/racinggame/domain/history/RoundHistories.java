package racinggame.domain.history;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;
import racinggame.domain.car.Cars;
import racinggame.domain.winner.Winners;

public class RoundHistories {

    private final List<RoundHistory> allRoundHistory = new ArrayList<>();


    public void captureRoundHistory(final Cars cars) {
        List<CarHistory> carHistories = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carHistories.add(new CarHistory(car));
        }
        allRoundHistory.add(new RoundHistory(carHistories));

    }

    private int findMaxLocation() {
        RoundHistory roundHistory = allRoundHistory.get(allRoundHistory.size() - 1);
        int maxLocation = 0;
        for (CarHistory carHistory : roundHistory.getRoundHistory()) {
            maxLocation = Math.max(carHistory.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public Winners findWinners() {
        RoundHistory roundHistory = allRoundHistory.get(allRoundHistory.size() - 1);
        return new Winners(roundHistory.getRoundHistory(), this.findMaxLocation());
    }


    public List<RoundHistory> getAllRoundHistory() {
        return new ArrayList<>(allRoundHistory);
    }
}
