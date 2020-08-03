package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.Printer;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    private static final String MOVING_NOTATION = "-";
    private static final String IGNORE_NOTATION = "";

    public static void markMove(List<Car> cars) {
        cars.forEach(ResultView::markPosition);
        Printer.skip();
    }

    private static void markPosition(Car car) {
        StringJoiner joiner = new StringJoiner(IGNORE_NOTATION);
        for (int i = 0; i < car.getPosition(); i++) {
            joiner.add(MOVING_NOTATION);
        }
        Printer.display(joiner.toString());
    }
}
