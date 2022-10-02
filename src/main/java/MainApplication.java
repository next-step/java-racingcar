import static racingcar.view.InputView.inputCarNumber;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class MainApplication {

    public static void main(String[] args) {
        int carNumber = inputCarNumber();
        int tryNumber = inputTryNumber();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }

        printResult(cars, tryNumber);
    }
}
