package racing.view;

import racing.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static String MARK = "-";

    public void resultPrint(Map<String,Integer> cars) {

        for (Map.Entry<String, Integer> car: cars.entrySet()) {
            String resultOutputString = makeResultString(car.getValue(), car.getKey());
            System.out.println(resultOutputString);
        }
        System.out.println();
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
