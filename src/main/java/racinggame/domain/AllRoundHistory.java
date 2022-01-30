package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class AllRoundHistory {

    private final List<RoundHistory> allRoundHistory = new ArrayList<>();


    public void captureRoundHistory(Cars cars) {
        List<CarHistory> carHistories = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carHistories.add(new CarHistory(car));
        }
        allRoundHistory.add(new RoundHistory(carHistories));

    }

    public List<RoundHistory> getAllRoundHistory(){
        return new ArrayList<>(allRoundHistory);
    }
}
