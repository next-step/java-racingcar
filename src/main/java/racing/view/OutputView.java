package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Cars;
import racing.domain.car.Car;
import racing.domain.car.Name;
import racing.domain.car.Position;

public class OutputView {

    private static final String SEPARATOR_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MOVE_STATE = "-";

    private OutputView() {
    }

    public static void printGameResult(List<List<Car>> raceStates) {
        System.out.println("\n실행 결과");
        for (List<Car> raceState : raceStates) {
            printCarHistories(raceState);
            System.out.println();
        }
    }

    private static void printCarHistories(List<Car> raceState) {
        for (Car car : raceState) {
            printCarHistory(car);
            System.out.println();
        }
    }

    private static void printCarHistory(Car car) {
        System.out.print(car.getNameValue() + SEPARATOR_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < car.getPositionValue(); i++) {
            System.out.print(MOVE_STATE);
        }
    }

    public static void printWinners(String winnersName) {
        System.out.println("최종 우승자 : " + winnersName);
    }
}
