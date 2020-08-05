package step4.ui;

import step4.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public final static String NEW_LINE = "\n";
    private final static String DRIVING_MARK = "-";

    public static void racingRelay(String driver, int location) {
        showDriver(driver);
        showDistanceDriven(location);
    }

    private static void showDriver(String driver) {
        drawLine(driver + " : ");
    }

    private static void showDistanceDriven(int myLocation) {
        for (int i = 0; i < myLocation; i++) {
            drawLine(DRIVING_MARK);
        }
        drawLine(NEW_LINE);
    }

    public static void drawLine(String msg) {
        System.out.print(msg);
    }

    public static void showFinalChampion(List<Car> cars, int finalChampion) {
        String msg = cars.stream()
                .filter(car ->
                        finalChampion == car.getLocation())
                .map(Car::getDriverName)
                .collect(Collectors.joining(","));
        System.out.println("win is : " + msg);
    }

    public static void raceStartAnnounce(List<Car> cars) {
        drawLine("실행 결과");
        drawLine(NEW_LINE);
        for (Car a : cars) {
            a.myState();
        }
        drawLine(NEW_LINE);
    }

}
