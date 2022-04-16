package racing.view;

import java.util.Map;

public class RacingViewRepository {
    Map<String, StringBuilder> carPrinter;

    public RacingViewRepository(Map<String, StringBuilder> carPrinter) {
        this.carPrinter = carPrinter;
    }

    public void add(String carName) {
        carPrinter.get(carName).append("-");
    }

    public void print(String carName) {
        System.out.println(carName + ": " + carPrinter.get(carName));
    }
}
