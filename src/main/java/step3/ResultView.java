package step3;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            printTraceEachCar(car.getTrace());
        }
        System.out.println();
    }

    public static void printTraceEachCar(int trace) {
        for (int i = 0; i < trace; i++)
            System.out.print("-");
        System.out.println();
    }
}
