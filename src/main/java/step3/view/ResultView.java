package step3.view;

import step3.CarList;
import step3.SimpleCar;

public class ResultView {

    public static void printRunResultText() {
        System.out.println("실행 결과");
    }

    public static void printCarsRunState(CarList cars) {
        cars.getCopiedCars().forEach(ResultView::printCarRunState);
        System.out.println();
    }

    private static void printCarRunState(SimpleCar car) {
        System.out.println("-".repeat(car.getPosition()));
    }
}
