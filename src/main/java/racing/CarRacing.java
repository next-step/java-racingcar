package racing;

import racing.domain.Grid;
import racing.view.InputView;

import java.util.LinkedList;

public class CarRacing {

    private static int cars = 0;
    private static int rounds = 0;

    public CarRacing() {
        InputView inputView = new InputView();
        cars = inputView.getManyCars();
        rounds = inputView.getTryCount();
    }

    public Grid start() {
        return new Grid(new LinkedList<>())
                .lineUp(cars)
                .standingStart(rounds)
                .finished();
    }
}
