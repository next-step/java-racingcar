package racingcar;

import java.util.List;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printFirstLine() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getName() + " : " + getLengthString(car.getPosition()));
        }
        System.out.println();
    }

    private static String getLengthString(int length) {
        return "-".repeat(length);
    }
}
