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

    public RacingGame(RacingRequestView view, Condition condition) {
        for (int i = 0; i < view.getCarCount(); i++) {
            cars.add(new Car(view.getCarName(i)));
        }

        this.time = view.getGameCount();
        this.condition = condition;
    }

    public RacingGameResult start() {
        RacingGameResult result = new RacingGameResult();
        for (int i = 0; i < time; i++) {
            turn();
            result.addHistory(getViews());
        }

        return result.judge(cars);
    }

    private void turn() {
        cars.stream().forEach(this::play);
    }

    private void play(Car car) {
        if (condition.check()) {
            car.move();
        }
    }

    public RacingCarsView getViews() {
        return RacingCarsView.toRacingCarsView(Collections.unmodifiableList(cars));
    }
}


