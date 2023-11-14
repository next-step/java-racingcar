package racing;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        String[] splitCarName = splitCarName(carNames);
        int retryCount = inputView.getRetryCount();

        List<Car> cars = createCar(splitCarName);

        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        raceCars(cars, retryCount, resultView);

    }

    private static List<Car> createCar(String[] splitCarName) {
        List<Car> cars = new ArrayList<>();
        for (String s : splitCarName) {
            cars.add(new Car(s));
        }
        return cars;
    }

    private static void raceCars(List<Car> cars, int retryCount, ResultView resultView) {
        for (int i = 0; i < retryCount; i++) {
            moveCars(cars);
            resultView.print(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public static String[] splitCarName(String carNames) {
        return carNames.split(",");
    }
}
