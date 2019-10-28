package racing;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameResultView {

    private static final String GO = "-";
    private static final String STOP = "";

    public void printResult(Map<Integer, List<CarNextStep>> participant) {
        participant.values().forEach(steps -> {
            steps.stream().forEach(step -> {
                printLine(step);
            });
            printEmptyLine();
        });
        printEmptyLine();
    }

    private void printLine(CarNextStep step) {
        if (step == CarNextStep.STOP) {
            System.out.print(STOP);
            return;
        }
        System.out.print(GO);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
