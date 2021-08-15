package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printEachRoundCarStatus(List<List<Car>> carsStatusPerRound) {
        printResultTitle();
        carsStatusPerRound.forEach(ResultView::printCarsStatusOfCurrentRound);
    }

    private static void printResultTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarsStatusOfCurrentRound(List<Car> cars) {
        cars.forEach(ResultView::printCarStatus);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        printCarName(car.getCarName());
        printDelimiter();
        printCarPositionAsHyphens(car.getCarPosition());
    }

    private static void printDelimiter() {
        System.out.print(" : ");
    }

    private static void printCarName(String name) {
        System.out.print(name);
    }

    private static void printCarPositionAsHyphens(Integer position) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < position; k++) {
            sb.append("-");
        }
        System.out.println(sb);
    }

    public static void printWinners(Winners winners) {
        String winnerNames = winners.getWinners().stream().map(Car::getCarName).collect(Collectors.joining(","));
        StringBuilder sb = new StringBuilder();
        sb.append(winnerNames);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
