package step3;

import static step3.ResultView.resultView;

import java.util.List;
import java.util.Random;

public class RacingCar {

    private static final Random random = new Random();

    public RacingCar() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<Car> carList = inputView.carNames();
        int carRunningNumber = inputView.carRunningNumber();
        resultView.startView();
        for(int i = 0; i < carRunningNumber; i++) {
            advanceCar(carList);
        }

    }

    private static void advanceCar(List<Car> cars) {
        for (Car car : cars) {
            Position position = car.advanceCar(random.nextInt(10));
            resultView(car.currentName(), position);
        }
        System.out.println();
    }
}
