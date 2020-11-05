package racing;

import java.util.LinkedList;

public class Racing {

    private static int cars = 0;
    private static int rounds = 0;

    public Racing() {
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
