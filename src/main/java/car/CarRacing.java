package car;

import java.util.List;

public class CarRacing {
    private final InputView inputView;

    public CarRacing() {
        inputView = new InputView();
    }

    public void start() {
        int carNum = inputView.enterCarCount();
        int tryNum = inputView.enterTryCount();

        List<Car> cars = CarFactory.generateCar(carNum);

        racing(cars, tryNum);
    }

    public void racing(List<Car> cars, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.racing();
            }
        }
    }
}
