package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.CarHistory;
import racing.domain.Cars;

public class OutputView {

    private static final String SEPARATOR_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MOVE_STATE = "-";
    private static final String COMMA = ",";

    private OutputView() {
    }

    public static void printGameResult(List<List<CarHistory>> raceHistories) {
        System.out.println("\n실행 결과");
        for (List<CarHistory> carHistories : raceHistories) {
            printCarHistories(carHistories);
            System.out.println();
        }
    }

    private static void printCarHistories(List<CarHistory> carHistories) {
        for (CarHistory carHistory : carHistories) {
            printCarHistory(carHistory);
            System.out.println();
        }
    }

    private static void printCarHistory(CarHistory carHistory) {
        System.out.print(carHistory.getName() + SEPARATOR_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < carHistory.getPosition(); i++) {
            System.out.print(MOVE_STATE);
        }
    }

    public static void printWinners(Cars cars) {
        final String winners = cars.getCars().stream()
            .filter(car -> car.isSamePosition(cars.getMaxPosition()))
            .map(Car::getName)
            .collect(Collectors.joining(COMMA));
        System.out.println("최종 우승자 : " + winners);
    }
}
