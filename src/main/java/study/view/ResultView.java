package study.view;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public void beforeRacingPrintMessage() {
        System.out.println("\n실행 결과");
    }

    public void printOneRacingResult(ArrayList<String>[] raceList) {
        for (List<String> raceResult : raceList) {
            for (int i = 0; i < raceResult.size(); i++) {
                System.out.print(raceResult.get(i));
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
