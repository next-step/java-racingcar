package carracing.service;

import carracing.domain.Cars;
import carracing.view.ResultView;

public class CarRacing {

    private Cars cars;
    private int tryCount;

    public CarRacing() {}

    public void ready(String carNames, int tryCount) {
        cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        for (int turn = 0; turn < tryCount; turn++) {
            cars.play();
            ResultView.print(cars, turn);
        }

        ResultView.printWinner(cars);
    }
}
