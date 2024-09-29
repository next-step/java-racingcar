package race;

import java.util.List;

public class ResultView {

    public static void output(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarPosition());
        }
        System.out.println();
    }
}
