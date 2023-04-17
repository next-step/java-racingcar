package racingcar;

import java.util.*;

public class ResultView {

    public void printResult(Racing racing) {
        System.out.println("실행결과");
        List<RaceResult> results = racing.getRaceRecord();

        if (results.size() == 0) {
            return;
        }
        for (RaceResult result : results) {
            printGame(result);
        }
    }

    private void printGame(RaceResult result) {
        for (Map.Entry<String, Integer> entry : result.getResult().entrySet()) {
            System.out.print(entry.getKey() + " : ");
            printDistance(entry.getValue());
        }
        System.out.println();
    }

    private void printDistance(Integer result) {
        for (int i = 0; i < result; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
