package racingcar;

import java.util.List;

public class OutputView {

    public static void printMileage(List<Car> cars, boolean isFirst) {
        if (isFirst) {
            System.out.println("실행 결과");
        }
        for (Car car : cars) {
            System.out.println("-".repeat(car.getMoveTotalCnt()));
        }
        System.out.println();

    }
}
