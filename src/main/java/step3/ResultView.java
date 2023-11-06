package step3;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String COLON = " : ";
    private static final String TRACKING_SYMBOL = "-";

    public static void printResultInfoMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        printRoundResultPerCar(cars);
        System.out.println();
    }

    private static void printRoundResultPerCar(List<Car> cars) {
        cars.stream().forEach(ResultView::printRoundResult);
    }

    private static void printRoundResult(Car car) {
        printName(car.name());
        printPosition(car.position());
        System.out.println();
    }

    private static void printName(String name) {
        System.out.print(name + COLON);
    }

    private static void printPosition(int position) {
        IntStream.range(0, position).forEach(i -> System.out.print(TRACKING_SYMBOL));
    }

}
