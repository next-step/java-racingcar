import static racingcar.view.InputView.inputCarNumber;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.printResult;

import racingcar.Cars;
import racingcar.Racing;

public class MainApplication {

    public static void main(String[] args) {
        int carNumber = inputCarNumber();
        int tryNumber = inputTryNumber();

        Cars cars = new Cars(carNumber);

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            printResult(Racing.race(cars));
        }
    }
}
