package step6.view;

import step6.domain.Car;
import step6.domain.Cars;

import java.util.ArrayList;

public class ResultView {
    private static final String GUIDE_MESSAGE = "실행 결과";
    public static void printCurrentPosition(Cars cars) {
        for (Car car: cars.getCars()) {
            System.out.print(car.getCarName() + ": ");
            printPositionInfo(car.getPosition());
        }
        System.out.println();
    }

    private static void printPositionInfo(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResultGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printWinnerCars(ArrayList<String> winnerCars) {
        winnerCars.stream()
                .forEach(System.out::println);
    }
}
