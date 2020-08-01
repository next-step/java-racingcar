package step3.ui;

import step3.domain.Car;
import step3.domain.Input;

import java.util.List;

public class ResultView {
    private final static String DRIVING_MARK = "-";
    private final static String NEW_LINE = "\n";

    private static void drawLine(String msg) {
        System.out.print(msg);
    }

    private static void setCarPosition(List<Car> cars, int i) {
        for (int j = 0; j < cars.size(); j++) {
            showDistanceDriven(cars.get(j).getCarRaceRecords().get(i).getMyLocation());
        }
        drawLine(NEW_LINE);
    }

    private static void showDistanceDriven(int myLocation) {
        for (int i = 0; i < myLocation; i++) {
            drawLine(DRIVING_MARK);
        }
        drawLine(NEW_LINE);
    }

    public static void showResult(Input input) {
        drawLine(NEW_LINE);
        drawLine("실행 결과" + NEW_LINE);
        List<Car> cars = Car.ofRacingCarReady(input);
        for (int nowLap = 0; nowLap < input.getTotalLaps(); nowLap++) {
            setCarPosition(cars, nowLap);
        }
    }
}
