package carrace.ui;

import carrace.domain.Car;
import carrace.domain.RaceTrack;

import java.util.List;

public class ResultView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(RaceTrack raceTrack) {
        List<Car> carList = raceTrack.getCarList();
        printCarListPosition(carList);
        System.out.println();
    }

    private static void printCarListPosition(List<Car> carList) {
        for (Car car : carList) {
            printCarPosition(car);
        }
    }

    private static void printCarPosition(Car car) {
        int position = car.getPosition();
        System.out.println(convertPosition(position));
    }

    private static String convertPosition(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
