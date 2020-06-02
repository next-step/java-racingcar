package step4;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static String MARK = "-";

    public void resultPrint(List<Car> positionList) {
        for (Car car : positionList) {
            drawRepeat(car.getPosition(), car.getCarName());
        }
    }

    private void drawRepeat(int times, String carName) {
        String markFullString = String.join("", Collections.nCopies(times, MARK));
        System.out.println(carName + ": " + markFullString);
    }
}
