package racing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String MOVE_SYMBOL = "-";
    private static final String CAR_FORMAT = "%s : %s\n";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String NAME_DELIMITER = ", ";

    private ResultView() {

    }

    public static void printRaceResult(CarRace carRace) {
        carRace.getCars().forEach(ResultView::printCar);
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String names = cars.stream()
                .map(Car::getName)
                .map(CarName::toString)
                .collect(Collectors.joining(NAME_DELIMITER));
        System.out.printf(WINNER_FORMAT, names);
    }

    public static void printError(Exception exception) {
        if (exception instanceof CarNameTooLongException) {
            System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
            return;
        }

        System.out.println("Unexpected error : " + exception);
    }

    private static void printCar(Car car) {
        System.out.printf(CAR_FORMAT, car.getName(), formatCarDistance(car.getDistance()));
    }

    private static String formatCarDistance(CarDistance carDistance) {
        return MOVE_SYMBOL.repeat(carDistance.getDistance());
    }
}
