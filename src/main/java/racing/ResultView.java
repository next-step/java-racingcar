package racing;

import java.util.List;

public class ResultView {
    public static void showStatus(List<Car> cars){
        for (Car car: cars) {
            System.out.println(car.getCarName() + "\t: " + "-".repeat(car.getMoveCount()));
        }
        System.out.println();
    }

    public static void showResult(List<String> cars){
        String winners = String.join(", ", cars);
        System.out.println(String.format("우승자는 %s 입니다.", winners));
    }
}
