package carracing.race.ui;

import carracing.race.logic.AutomobileFederation;

import java.io.PrintStream;

public class ResultView {
    private final PrintStream printStream;
    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printResult(AutomobileFederation federation) {
        for (int lap : federation.allLap()) {
            for(String s :  federation.lapSituations(lap)) {
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
