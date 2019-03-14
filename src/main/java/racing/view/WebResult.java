package racing.view;

import java.util.List;
import java.util.Map;

public class WebResult {
    private Map<String, List<Integer>> cars;

    private String winners;

    public Map<String, List<Integer>> getCars() {
        return cars;
    }

    public void setCars(Map<String, List<Integer>> cars) {
        this.cars = cars;
    }

    public String getWinners() {
        return winners;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }
}
