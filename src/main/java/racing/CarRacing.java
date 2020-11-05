package racing;

import racing.view.ResultView;

public class CarRacing {
    public static void main(String[] args) {
        new ResultView().play(new Racing().start());
    }
}
