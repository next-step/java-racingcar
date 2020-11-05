package racing;

import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        new ResultView().play(new CarRacing().start());
    }
}
