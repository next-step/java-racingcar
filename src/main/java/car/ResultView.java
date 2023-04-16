package car;


import java.util.List;

public class ResultView {
    public static void printRaceResult(List<Car> cars) {
        System.out.println();
        for (Car car : cars) {
            car.printStatus();
        }
        System.out.println();
    }
}
