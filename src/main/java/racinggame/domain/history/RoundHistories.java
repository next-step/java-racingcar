package racinggame.domain.history;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.car.Car;
import racinggame.domain.winner.Winners;

public class RoundHistories {

    private static final int LAST_ROUND_HISTORY_SUB_NUMBER = 1;
    private final List<RoundHistory> allRoundHistory = new ArrayList<>();

    public void captureRoundHistory(final List<Car> cars) {
        List<Car> carsCapture = new ArrayList<>();
        for (Car car : cars) {
            carsCapture.add(new Car(car.getCarName(), car.getLocation()));
        }
        allRoundHistory.add(new RoundHistory(carsCapture));
    }

    private int findMaxLocation() {
        RoundHistory roundHistory = allRoundHistory.get(
            allRoundHistory.size() - LAST_ROUND_HISTORY_SUB_NUMBER);
        int maxLocation = 0;
        for (Car car : roundHistory.getRoundHistory()) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public Winners findWinners() {
        RoundHistory roundHistory = allRoundHistory.get(
            allRoundHistory.size() - LAST_ROUND_HISTORY_SUB_NUMBER);
        return new Winners(roundHistory.getRoundHistory(), this.findMaxLocation());
    }


    public List<RoundHistory> getAllRoundHistory() {
        return new ArrayList<>(allRoundHistory);
    }
}
