package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String CAR_RACER_SPLITTER = " : ";
    private static final String CAR_MOVE_CHAR = "-";
    private static final String CAR_WINNER_DELIMITER = ", ";

    private OutputView() {}

    public static void printDistance(final Cars cars) {
        cars.get()
            .forEach(OutputView::carStatus);
        System.out.println();
    }

    private static void carStatus(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.name());
        sb.append(CAR_RACER_SPLITTER);
        for (int index = 0; index < car.distance(); index++) {
            sb.append(CAR_MOVE_CHAR);
        }
        System.out.println(sb);
    }

    public static void printWhoIsWinner(final Cars cars) {
        String winners = winners(cars);
        System.out.print("최종 우승자 : " + winners);
    }

    public static void printTurnResult() {
        System.out.println("실행 결과");
    }

    private static String winners(final Cars cars) {
        return cars.filterWinners().stream()
            .map(Car::name)
            .collect(Collectors.joining(CAR_WINNER_DELIMITER));
    }
}
