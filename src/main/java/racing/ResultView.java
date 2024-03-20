package racing;


import java.util.List;

public class ResultView {
    static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarResult(car);
        }
    }

    static void printCarResult(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
