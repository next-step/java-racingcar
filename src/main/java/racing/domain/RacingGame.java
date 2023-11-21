package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {
    public static void main(String[] args) {

        MoveStrategy moveStrategy = new RandomMoveStrategy();

        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        String[] splitCarName = splitCarName(carNames);
        int retryCount = inputView.getRetryCount();

        Cars cars = createCar(splitCarName);

        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        for (int i = 0; i < retryCount; i++) {
            cars.moveCars(moveStrategy);
            resultView.print(cars);
        }
        resultView.printWinner(cars.getWinner());
    }

    private static Cars createCar(String[] splitCarName) {
        List<Car> cars = new ArrayList<>();
        for (String name : splitCarName) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }


    public static String[] splitCarName(String carNames) {
        return carNames.split(",");
    }

}
