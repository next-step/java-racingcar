package racing.view;

import racing.core.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DISTANCE_MARKER = "-";
    private static final String START_TEXT = "실행 결과";
    private static final String WINNER_TEXT = "가 최종 우승했습니다.";
    private static final String WINNER_SEPARATE_TEXT = ", ";

    public void printStartText() {
        System.out.println();
        System.out.println(START_TEXT);
    }

    public void printCarList(Cars cars) {
        cars.getCarStream().forEach(this::printCarDistance);
        System.out.println();
    }

    private void printCarDistance(Car car) {
        CarName carName = car.getCarName();
        Distance distance = car.getDistance();
        System.out.println(carName.getName() + " : " + DISTANCE_MARKER.repeat(Math.max(0, distance.getDistance())));
    }

    public void printWinners(Cars winners) {
        List<String> winnerNames = winners.getCarStream()
                .map(car -> car.getCarName().getName())
                .collect(Collectors.toList());
        System.out.print(String.join(WINNER_SEPARATE_TEXT, winnerNames) + WINNER_TEXT);
    }
}
