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
            System.out.println(car.getRacingResult());
        }
    }

}
