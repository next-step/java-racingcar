package step3;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String TRACKING_SYMBOL = "-";

    public static void printResultInfoMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        printAllPosition(cars);
        System.out.println();
    }

    private static void printAllPosition(List<Car> cars) {
        cars.stream().forEach(ResultView::printPosition);
    }

    private static void printPosition(Car car) {
        printTrackingSymbol(car.position());
        System.out.println();
    }

    private static void printTrackingSymbol(int position) {
        IntStream.range(0, position).forEach(i -> System.out.print(TRACKING_SYMBOL));
    }

}
