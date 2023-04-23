package racingcar.view;

import racingcar.CarList;
import racingcar.SimpleCar;

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
