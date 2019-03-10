package racing.application;

import racing.view.RacingRequestView;
import racing.view.RacingCarsView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars = new ArrayList();

    public RacingGame(RacingRequestView view) {
        for (int i = 0; i < view.getCarCount(); i++) {
            cars.add(new Car());
        }

        this.time = view.getGameCount();
    }

    public RacingCarsView run() {
        cars.stream().forEach(car -> car.move());
        return new RacingCarsView(cars);
    }

    public RacingCarsView getView() {
        return new RacingCarsView(cars);
    }

    public int getPosition(int index) {
        return cars.get(index).getPosition();
    }

    public int getTime() {
        return time;
    }
}


