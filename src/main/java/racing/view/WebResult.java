package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.Map;

public class WebResult {
    private Map<String, List<Integer>> cars;

    private List<List<Car>> roundHistory;

    private String winners;

    public Map<String, List<Integer>> getCars() {
        return cars;
    }

    public void setCars(Map<String, List<Integer>> cars) {
        this.cars = cars;
    }

    public List<List<Car>> getRoundHistory() {
        return roundHistory;
    }

    public void setRoundHistory(List<List<Car>> roundHistory) {
        this.roundHistory = roundHistory;
    }

    public String getWinners() {
        return winners;
    }

    public void setWinners(String winners) {
        this.winners = winners;
    }
}
