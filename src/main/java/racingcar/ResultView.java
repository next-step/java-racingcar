package racingcar;

import java.util.List;

public class ResultView {

    public static void printFirstLine() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getPositionString());
        }
        System.out.println();
    }
}
