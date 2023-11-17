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
        resultView.printWinner(winner(cars));
    }

    private static List<Car> createCar(String[] splitCarName) {
        List<Car> cars = new ArrayList<>();
        for (String name : splitCarName) {
            cars.add(new Car(name));
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

    public static String winner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        getMaxPosition(cars, maxPosition, winners);
        return String.join(",", winners);
    }

    private static void getMaxPosition(List<Car> cars, int maxPosition, List<String> winners) {
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
    }
}
