package step4;

import java.util.Random;
import step4.model.Car;
import step4.view.InputView;
import step4.view.ResultView;

public class RacingCarApplication {

    private static final Random random = new Random();
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {

        String[] carNames = inputView.carName().split(",");
        int carNumber = inputView.carNumber();
        Car[] cars = newCar(carNames);
        resultView.startResultView();
        for (int i = 0; i < carNumber; i ++) {
            advance(cars);
        }
    }

    private static Car[] newCar(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for(int i = 0; i < carNames.length; i ++) {
            cars[i] = new Car(carNames[i], 0);
        }
        return cars;
    }

    private static void advance(Car[] cars) {
        for (Car car : cars) {
            resultView.result(car.currentName(), car.advanceCar(random.nextInt(9)));
        }
    }

}
