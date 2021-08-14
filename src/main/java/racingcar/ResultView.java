package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(List<List<Car>> carsStatusPerRound) {
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
}
