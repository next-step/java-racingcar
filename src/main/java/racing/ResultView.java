package racing;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars) {
        for(Car car:cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
    public static void printWinners(List<Car> cars) {
        for(Car car:cars) {
            System.out.print(car.getName() + ",");
        }
        System.out.println("가 최종 우승했습니다.");
    }

}
