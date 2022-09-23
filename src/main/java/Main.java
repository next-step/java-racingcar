import racingcar.Cars;
import racingcar.model.InputView;
import racingcar.model.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView input = InputView.scan();

        Cars cars = Cars.of(input.carNames());

        ResultView.printStartComment();
        for (int i = 0; i < input.tryCount(); i++) {
            cars = cars.race();

            ResultView.printRacing(cars);
        }
        ResultView.printWinners(cars);
    }
}
