package view;

import car.Car;
import car.Cars;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final char CAR_LOCATION_INDICATOR = '-';

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printCars(Cars cars) {
        for(Car car: cars.getCars()) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int position) {
        for(int i = 0; i < position; i++) {
            System.out.print(CAR_LOCATION_INDICATOR);
        }
        System.out.println();
    }
}
