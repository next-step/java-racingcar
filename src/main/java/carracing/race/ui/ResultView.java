package carracing.race.ui;

import carracing.race.logic.AutomobileFederation;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {
    private final PrintStream printStream;
    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printResult(AutomobileFederation federation) {
        Map<Integer, List<Integer>> raceResults = federation.getResult();

        ArrayList<Integer> race = new ArrayList<>(raceResults.keySet());
        for (int lap : race) {
            List<Integer> raceResultThisLap = raceResults.get(lap);
            for (int recordCurrentCar : raceResultThisLap) {
                // printStream.print(resultEachCar);
                printStream.print(isForward(recordCurrentCar));
                printStream.print(" ");

            }
            printStream.println("");
        }
        printStream.println();
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
