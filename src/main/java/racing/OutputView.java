package racing;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static String MARK = "-";

    public void resultPrint(List<Car> positions) {
        for (Car car : positions) {
            String resultOutputString = makeResultString(car.getPosition(), car.getCarName());
            System.out.println(resultOutputString);
        }
    }

    private String makeResultString(int times, String carName) {
        String markFullString = String.join("", Collections.nCopies(times, MARK));
        return carName + ": " + markFullString;
    }

    public void printWinner(List<String> cars) {
        String winnerNames = String.join(",", cars);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
