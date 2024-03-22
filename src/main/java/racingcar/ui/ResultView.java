package racingcar.ui;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_DISTANCE = "-";
    private static final String NAME_DELIMITER = ": ";
    private static final String WINNER_DELIMITER = ", ";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printMove(Cars cars) {
        cars.getCars().forEach(ResultView::printCarDistance);
        printLineBreak();
    }

    private static void printCarDistance(Car car) {
        String distanceView = getCarName(car);
        String result = distanceView + PRINT_DISTANCE.repeat(car.getDistance());
        System.out.println(result);
    }

    private static String getCarName(Car car) {
        return car.getName() + NAME_DELIMITER;
    }

    public void printLineBreak() {
        System.out.println();
    }

    public void printRacingcarWinners(List<Car> winners) {
        System.out.println(getWinnersName(winners) + "가 최종 우승했습니다.");
    }

    private static String getWinnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

}
