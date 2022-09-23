package car;

import java.util.List;

public class CarRacing {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomUtil randomUtil;

    public CarRacing(InputView inputView, ResultView resultView, RandomUtil randomUtil) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomUtil = randomUtil;
    }

    public void start() {
        int carNum = inputView.enterCarCount();
        int tryNum = inputView.enterTryCount();

        List<Car> cars = CarFactory.generateCar(carNum);

        racing(cars, tryNum);
    }

    private void racing(List<Car> cars, int tryNum) {
        System.out.println("실행결과");
        for (int i = 0; i < tryNum; i++) {
            for (Car car : cars) {
                car.racing(randomUtil);
            }
            resultView.print(cars, i);
        }
    }
}
