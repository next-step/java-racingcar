package racing.application;

import racing.view.RacingCarsView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    List<String> winners = new ArrayList();
    List<RacingCarsView> history = new ArrayList();

    public RacingGameResult judge(List<Car> cars) {
        List<Car> sorted = sortByPosition(cars);
        winners = getCarNameOfWinners(sorted);
        return this;
    }

    private List<Car> sortByPosition(List<Car> cars) {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getCarNameOfWinners(List<Car> sorted) {
        return sorted.stream()
                .filter(v -> getWinnerPosition(sorted) == v.getPosition())
                .map(v -> v.getName())
                .collect(Collectors.toList());
    }

    private int getWinnerPosition(List<Car> sorted) {
        return sorted.get(0).getPosition();
    }

    public void addHistory(RacingCarsView view) {
        history.add(view);
    }

    public List<RacingCarsView> getHistory(){
        return history;
    }

    public String getWinners() {
        return winners.stream().collect(Collectors.joining(","));
    }
}
