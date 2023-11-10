package step3;

import java.util.List;

public class ResultView {

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public void printCarPosition(Car car) {
        System.out.print(car.name() + " : ");
        for (int i = 0; i < car.position(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
