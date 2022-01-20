package racingcar.utils;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String MARK = "-";

    private OutputView() {
    }

    public static void showResult(List<Car> cars) {
        cars.forEach(OutputView::showCarStatus);
        System.out.println();
    }

    private static void showCarStatus(Car car) {
        String position = createPositionBar(car.position());
        System.out.println(car.name().getName() + ": " + position);
    }

    private static String createPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        while (position-- > 0) {
            positionBar.append(MARK);
        }
        return positionBar.toString();
    }
}
