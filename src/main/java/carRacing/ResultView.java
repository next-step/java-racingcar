package carRacing;

import java.util.List;

public class ResultView {


    public static void resultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> carList) {

        for (Car car : carList) {
            String distance = "-".repeat(car.getDistance());
            System.out.println(distance);
        }
        System.out.println();
    }
}
