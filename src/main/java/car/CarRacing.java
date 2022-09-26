package car;

import java.util.List;

public class CarRacing {
    private final InputView inputView;
    private final ResultView resultView;

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        List<Car> cars = inputView.enterCar();
        int tryNum = inputView.enterTryCount();

        resultView.print(cars, tryNum);
    }
}
