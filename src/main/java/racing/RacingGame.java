package racing;

import racing.data.Messages;
import racing.utils.RandomUtils;
import racing.views.InputView;
import racing.views.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static void main(String[] args) {

        String[] carNames = InputView.inputCarNames();

        List<Car> cars = generateCarsWithName(carNames);

        int tryTimes = InputView.inputTryTimes();

        ResultView.showResult();

        for (int j = 0; j < tryTimes; j++) {
            moveCars(cars);
        }

        Judgement judgement = new Judgement();

        List<Car> winnerCars = judgement.getWinnerCars(cars);

        ResultView.printWinner(winnerCars);
    }

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtils.generateRandomNumber(10));
            ResultView.printResultWithName(car);
        }
        ResultView.println("");
    }

    public static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public static List<Car> generateCarsWithName(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }
}
