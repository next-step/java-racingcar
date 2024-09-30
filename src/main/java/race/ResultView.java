package race;

import java.util.List;

public class ResultView {

    private static final String EXPRESS_STRING = "-";

    public static void output(List<Car> cars) {
        for (Car car : cars) {
            carForwardPrint(car);
        }
        System.out.println();
    }

    private static void carForwardPrint(Car car) {
        for (int i = 0; i < car.getForwardResult(); i++) {
            System.out.print(EXPRESS_STRING);
        }
        System.out.println();
    }
}
