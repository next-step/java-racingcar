package step3;

import java.util.List;

public class OutputView {

    public static void printCarPosition(List<Car> cars) {
        cars.forEach(car -> printPosition(car.getPosition()));
        System.out.println();
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
