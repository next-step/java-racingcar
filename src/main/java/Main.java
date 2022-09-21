import racingcar.CarList;
import racingcar.model.InputView;
import racingcar.model.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView input = InputView.scan();

        CarList cars = CarList.initialize(input.carCount());

        ResultView.printStartComment();
        for (int i = 0; i < input.tryCount(); i++) {
            cars = cars.next();

            ResultView.print(cars);
        }
    }
}
