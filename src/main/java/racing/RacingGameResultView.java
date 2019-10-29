package racing;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameResultView {

    public static void printResult(Map<Integer, List<CarNextStep>> participant) {
        participant.values().forEach(steps -> {
            steps.stream().forEach(step -> {
                printLine(step);
            });
            printEmptyLine();
        });
        printEmptyLine();
    }

    private static void printLine(CarNextStep step) {
        if (step == CarNextStep.STOP) {
            System.out.print(step.getText());
            return;
        }
        System.out.print(step.getText());
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
