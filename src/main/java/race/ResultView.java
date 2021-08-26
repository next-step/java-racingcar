package race;

import java.util.Map;

public class ResultView {

    protected static void printResult(Cars cars) {
        for (Map.Entry<String, Car> entry : cars.getCarMap().entrySet()) {
            System.out.println(convertDistanceToLine(entry.getValue()));
        }
        System.out.println();
    }

    private static String convertDistanceToLine(Car car) {
        StringBuilder sb = new StringBuilder();
        for (Boolean b : car.getDistance()) {
            sb.append(b ? "-" : "");
        }
        return sb.toString();
    }
}
