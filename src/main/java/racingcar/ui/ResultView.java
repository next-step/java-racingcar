package racingcar.ui;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_DISTANCE = "-";
    private static final String NAME_DELIMITER = ": ";
    private static final String WINNER_DELIMITER = ", ";

    private static ResultView instance = new ResultView();

    private ResultView() {
        System.out.println("실행 결과");
    }

    public static ResultView getInstance() {
        return instance;
    }

    public void printMove(List<Car> carList) {
        carList.forEach(ResultView::printCarDistance);
    }

    private static void printCarDistance(Car car) {
        String distanceView = getCarName(car);
        for (int i = 0; i < car.getDistance(); i++) {
            distanceView += PRINT_DISTANCE;
        }
        System.out.println(distanceView);
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
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
        return winnersName;
    }

}
