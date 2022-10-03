import static racingcar.view.InputView.inputCarNumber;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import racingcar.Cars;

public class MainApplication {

    public static void main(String[] args) {
        int carNumber = inputCarNumber();
        int tryNumber = inputTryNumber();

        Cars cars = new Cars();
        cars.add(carNumber);

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            cars.moveAll();
            printResult(cars);
        }
    }
}
