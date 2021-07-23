package step3.ui;

import java.util.List;
import step3.domain.Car;

public class ResultView {

    private static final String PROGRESS_SYMBOL = "-";

    private ResultView() {
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            String progressString = generateProgressString(car.getRunDistance());
            System.out.println(progressString);
        }
        System.out.println();
    }

    private static String generateProgressString(int runDistance) {
        String progress = "";
        for (int i = 0; i < runDistance; i++) {
            progress = progress + PROGRESS_SYMBOL;
        }
        return progress;
    }


}
