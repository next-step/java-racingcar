package step4.view;

import step4.model.Car;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars) {
        Print.print("실행 결과");
        Print.printWinner(cars);
    }
    public static void printCars(List<Car> cars) {
        Print.print(cars);
    }
}
