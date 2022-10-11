package racing.view;

import racing.core.Car;

import java.util.List;

public class ResultView {
    private static final String DISTANCE_MARKER = "-";
    private static final String START_TEXT = "실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";
    private static final String WINNER_SEPARATE_TEXT = ", ";

    public void printStartText() {
        System.out.println();
        System.out.println(START_TEXT);
    }

    public void printCarList(List<Car> carList) {
        carList.forEach(this::printCarDistance);
        System.out.println();
    }

    private void printCarDistance(Car car) {
        System.out.println(car.getCarName() + " : " + DISTANCE_MARKER.repeat(Math.max(0, car.getDistance())));
    }

    public void printWinners(List<Car> winners) {
        System.out.print(winners.get(0));
        if (winners.size() == 1) {
            System.out.print(WINNER_TEXT);
            return;
        }
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(WINNER_SEPARATE_TEXT);
            System.out.print(winners.get(i));
        }
        System.out.print(WINNER_TEXT);
    }
}
