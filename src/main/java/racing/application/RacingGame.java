package racing.application;

import racing.view.RacingCarsView;
import racing.view.RacingRequestView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars = new ArrayList();
    private List<RacingCarsView> history = new ArrayList();

    public RacingGame(RacingRequestView view) {
        for (int i = 0; i < view.getCarCount(); i++) {
            cars.add(new Car());
        }

        this.time = view.getGameCount();
    }

    public void start(Game game) {
        for (int i = 0; i < time; i++) {
            turn(game);
            history.add(getView());
        }
    }

    private void turn(Game game) {
        cars.stream().forEach(car -> play(game, car));
    }

    private void play(Game game, Car car) {
        if (game.win()) {
            car.move();
        }
    }

    public RacingCarsView getView() {
        return RacingCarsView.toRacingCarsView(cars);
    }

    public List<RacingCarsView> getHistory() {
        return history;
    }
}


