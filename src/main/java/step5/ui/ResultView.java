package step5.ui;

import step5.domain.Car;

import java.util.List;

public class ResultView {
    private final static String DRIVING_MARK = "-";
    public final static String NEW_LINE = "\n";

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

    public static void raceStartAnnounce(List<Car> cars) {
        drawLine("실행 결과");
        drawLine(NEW_LINE);
        cars.forEach(ResultView::accept);
        drawLine(NEW_LINE);
    }

    public static void raceWinnerAnnounce(String winner) {
        drawLine("win is : " + winner);
    }

    private static void accept(Car car) {
        ResultView.racingRelay(car.getDriverName(), car.getLocation());
    }
}
