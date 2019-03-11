package racing.application;

import racing.infrastructure.CarMoveValidation;
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

    public RacingCarsView start() {
        List<Car> result = run(cars);
        return RacingCarsView.toRacingCarsView(result);
    }

    protected List<Car> run(List<Car> cars) {
        cars.stream().forEach(car -> runByPlayer(car, play()));
        return cars;
    }

    protected int runByPlayer(Car car, boolean movable) {
        return car.move(movable);
    }

    protected boolean play() {
        return new CarMoveValidation().check();
    }

    public RacingCarsView getView() {
        return RacingCarsView.toRacingCarsView(cars);
    }

    public int getTime() {
        return time;
    }
}


