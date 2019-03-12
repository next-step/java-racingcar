package racing.application;

import racing.view.RacingCarsView;
import racing.view.RacingRequestView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Condition condition;
    private int time;
    private List<Car> cars = new ArrayList();
    private List<RacingCarsView> history = new ArrayList();

    public RacingGame(RacingRequestView view, Condition condition) {
        for (int i = 0; i < view.getCarCount(); i++) {
            cars.add(new Car(view.getCarName(i)));
        }

        this.time = view.getGameCount();
        this.condition = condition;
    }

    public void start() {
        for (int i = 0; i < time; i++) {
            turn();
            history.add(getViews());
        }
    }

    private void turn() {
        cars.stream().forEach(car -> play(car));
    }

    private void play(Car car) {
        if (condition.check()) {
            car.move();
        }
    }

    public RacingCarsView getViews() {
        return RacingCarsView.toRacingCarsView(cars);
    }

    public List<RacingCarsView> getHistory() {
        return history;
    }

    public List<String> judgeWinners() {
        List<Car> sorted = sortByPosition(cars);
        return getCarNameOfWinners(sorted);
    }

    public List<Car> sortByPosition(List<Car> cars) {
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
}


