package car;


import java.util.List;

public class ResultView {
    public static void printRaceResult(List<Car> cars, String format) {
        System.out.println();
        for (Car car : cars) {
            int position = car.getPosition();
            String carStatus = car.getName() + " : " + format.repeat(position);
            System.out.println(carStatus);
        }
        System.out.println();
    }
}
