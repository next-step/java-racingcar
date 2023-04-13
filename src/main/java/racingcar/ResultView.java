package racingcar;

import java.util.List;

public class ResultView {

    public void printResult(Racing racing) {
        System.out.println("실행결과");
        List<List<Integer>> raceRecord = racing.getRaceRecord();

        if (raceRecord.size() == 0) {
            return;
        }
        for (List<Integer> results : raceRecord) {
            printGame(results);
        }
    }

    private void printGame(List<Integer> results) {
        for (Integer result : results) {
            printDistance(result);
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
