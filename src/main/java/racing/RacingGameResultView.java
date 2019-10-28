package racing;

import java.util.List;
import java.util.Map;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-28 00:09
 */
public class RacingGameResultView {

    public static final String GO = "-";

    public static void printResult(Map<Integer, List<RacingGame.MoveStatus>> carMap) {
        carMap.entrySet().forEach(car -> {
            car.getValue().stream().filter(status -> status == RacingGame.MoveStatus.GO).forEach(go -> {
                printGoLine();
            });
            printEmptyLine();
        });
        printEmptyLine();
    }

    public static void printGoLine() {
        System.out.print(GO);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
