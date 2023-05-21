package step3;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String carStatus = car.getName() + " : " + "-".repeat(car.getTrace());
            System.out.println(carStatus);
        }
        System.out.println();
    }
}
