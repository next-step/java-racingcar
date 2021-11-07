package racingcar.view;
import racingcar.car.Cars;

public class ResultView {

    private ResultView() {}

    public static void print(Cars cars) {
        cars.printPosition();
    }
}
