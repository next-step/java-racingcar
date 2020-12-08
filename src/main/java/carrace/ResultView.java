package carrace;

import java.util.List;

public class ResultView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(RaceTrack raceTrack) {
        List<Car> carList = raceTrack.getCarList();
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println();
    }
}
