package racing.application;

import racing.view.RacingCarsView;
import racing.view.RacingRequestView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private Condition condition;
    private int time;
    private List<Car> cars = new ArrayList();
    private List<RacingCarsView> history = new ArrayList();
    private Result result = new RacingGameResult();

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

    public List<String> getResult() {
        return result.judge(cars);
    }

    public RacingCarsView getViews() {
        return RacingCarsView.toRacingCarsView(Collections.unmodifiableList(cars));
    }

    public List<RacingCarsView> getHistory() {
        return history;
    }
}


