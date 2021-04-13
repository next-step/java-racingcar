package carracing.service;

import carracing.domain.Cars;
import carracing.view.ResultView;

public class CarRacing {

    public void start(Cars cars, int tryCount) {
        for (int turn = 0; turn < tryCount; turn++) {
            cars.play();
            ResultView.print(cars, turn);
        }

        ResultView.printWinner(cars);
    }
}
