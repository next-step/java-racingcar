package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        new InputView();
        int cars = InputView.getManyCars();
        int rounds = InputView.getTryCount();
        new ResultView().racingResults(new CarRacing(cars,rounds).start());
    }
}
