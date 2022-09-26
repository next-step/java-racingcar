package step3.ui;

import java.util.List;
import step3.models.Car;

public class OutputView {
    private static final char MOVE_CHARACTER = '-';
    private static final String TITLE = "실행 결과";
    private final List<List<Car>> results;

    public OutputView(List<List<Car>> results) {
        this.results = results;
    }

    public void printResult() {
        System.out.println(TITLE);
        results.forEach(result -> {
            printCars(result);
            System.out.println();
        });
    }

    private void printCars(List<Car> cars) {
        cars.forEach(car -> {
            printPosition(car);
            System.out.println();
        });
    }

    private void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print(MOVE_CHARACTER);
        }
    }
}
