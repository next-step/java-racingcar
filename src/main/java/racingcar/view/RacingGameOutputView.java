package racingcar.view;

import racingcar.domain.Car;
import racingcar.vo.RacingResultOfRound;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameOutputView {
    private RacingGameOutputView() {
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void printMovedDistance(Car car) {
        StringBuilder visualizedMovedDitance = new StringBuilder();
        int movedDistanceOfCar = car.getMovedDistance();

        for (int i = 0; i < movedDistanceOfCar; i++) {
            visualizedMovedDitance.append("-");
        }

        System.out.println(visualizedMovedDitance);
    }

    public static void printRacingResult(RacingResultOfRound racingResult) {
        racingResult.getCarsOfRound().forEach(RacingGameOutputView::printMovedDistance);
    }

    public static void printWinners(List<Car> winners) {
        String winnerCarNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        printLine("실행 결과");
        printEmptyLine();
        printLine(winnerCarNames + "가 최종 우승했습니다.");
    }
}
