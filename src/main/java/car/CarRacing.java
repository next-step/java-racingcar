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
        int carNum = inputView.enterCarCount();
        int tryNum = inputView.enterTryCount();

        List<Car> cars = carFactory.generateCar(carNum);

        racing(cars, tryNum);
    }

    private void racing(List<Car> cars, int tryNum) {
        System.out.println("실행결과");
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.racing();
            }
            resultView.print(cars, i);
        }
    }
}
