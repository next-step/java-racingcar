package car;

import java.util.List;

public class CarRacing {
    private final InputView inputView;
    private final ResultView resultView;
    private final CarFactory carFactory;

    public CarRacing(InputView inputView, ResultView resultView, CarFactory carFactory) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.carFactory = carFactory;
    }

    public void start() {
        List<Car> cars = inputView.enterCar();
        int tryNum = inputView.enterTryCount();

        racing(cars, tryNum);
    }

    private void racing(List<Car> cars, int tryNum) {


    }
}
