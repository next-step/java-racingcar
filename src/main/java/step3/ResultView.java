package step3;

import java.util.List;

public class ResultView {

    public static void printResultStart() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getMoveStatus());
        }
        System.out.println();
    }

}
