package carracing.ui;

import carracing.logic.AutomobileFederation;
import carracing.logic.type.Round;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {
    private static final Boolean DISPLAY_CAR_INDEX = Boolean.TRUE;
    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printResult(AutomobileFederation federation) {
        if (!DISPLAY_CAR_INDEX) {
            printResultWithoutCarIndex(federation);
            return;
        }
        printResultWithCarIndex(federation);
    }

    public void printResultWithoutCarIndex(AutomobileFederation federation) {
        for (Round round : federation.getRounds()) {
            for (String s : federation.lapSituations(round)) {
                printStream.println(s);
            }
            printStream.println("");
        }
    }

    public void printResultWithCarIndex(AutomobileFederation federation) {
        for (Round round : federation.getRounds()) {
            AtomicInteger indexHolder = new AtomicInteger();
            for (String s : federation.lapSituations(round)) {
                printStream.print(indexHolder.getAndIncrement()+1);
                printStream.print(" : ");
                printStream.println(s);
            }
            printStream.println("");
        }
    }

    public static boolean isForward(int recode) {
        return recode >= 4;
    }
    /*
    도메인 정리
    Map<Integer, List<Integer>> raceResults
    키 > Lap

    1랩 >> 각 차 남바별로 성적이 출력

    recode >> 각 차량이 경기당 성적 , 0~9 범위값


     */


}
