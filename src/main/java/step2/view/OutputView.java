package step2.view;

import step2.domain.Car;
import step2.domain.Cars;

public class OutputView {
    private static final String POSITION_OF_CAR = "-";

    public static void showResultTitle() {
        System.out.println("실행 결과");
    }

    public OutputView(Cars cars) {
        for (Car car : cars.getCars()) {
            printCars(car);
        }
        printEmptyLine();
    }

    private void printCars(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
