package racingcar.view;

import racingcar.constant.RacingMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Printer;

import java.util.stream.Collectors;

public class ResultView {
    private static final String CAR_PREFIX = "%s : ";
    private static final String COMMA = ", ";
    private static final String MOVING_NOTATION = "-";
    private static final String NEXT_LINE = "\n";

    private ResultView() {}

    public static void markRacing(Cars cars) {
        Printer.display(markCarsMove(cars) + NEXT_LINE);
    }

    public static void printWinner(Cars cars) {
        Printer.display(String.format(RacingMessage.WINNER_MESSAGE_FORMAT, findWinnerNames(cars)));
    }

    private static String markCarsMove(Cars cars) {
        return cars.getCarList().stream()
                .map(ResultView::markCarFormat)
                .collect(Collectors.joining());
    }

    private static String findWinnerNames(Cars cars) {
        return cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));
    }

    private static String markPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(MOVING_NOTATION);
        }
        return stringBuilder.toString();
    }

    private static String markCarFormat(Car car) {
        return String.format(CAR_PREFIX, car.getName())
                + markPosition(car.getPosition())
                + NEXT_LINE;
    }
}
