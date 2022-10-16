package step3;

import java.util.List;

public class ResultView {

    private static final String TRY_RESULT = "실행 결과";

    private ResultView() {}

    public static void printResultComment() {
        System.out.println(TRY_RESULT);
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            printCarDistance(car);
        }
        System.out.println();
    }

    public static void printCarDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
