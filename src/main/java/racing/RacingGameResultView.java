package racing;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameResultView {

    private final String GO = "-";
    private final String STOP = "";

    public void printResult(Map<Integer, List<CarNextStep>> carMap) {
        carMap.values().forEach(car -> {
            car.stream().forEach(step -> {
                printLine(step);
            });
            printEmptyLine();
        });
        printEmptyLine();
    }

    public void printLine(CarNextStep step) {
        if (step == CarNextStep.STOP) {
            System.out.print(STOP);
            return;
        }
        System.out.print(GO);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
