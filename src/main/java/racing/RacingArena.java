package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int cars = inputView.getManyCars();
        int rounds = inputView.getTryCount();
        new ResultView().play(new CarRacing(cars,rounds).start());
    }
}
