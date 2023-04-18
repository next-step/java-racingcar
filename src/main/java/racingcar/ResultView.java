package racingcar;

import java.util.List;

public class ResultView {
    public static final String FOOTPRINT = "﹣";

    public static void printResult(List<Result> results) {
        System.out.println("[실행 결과]");
        for (Result result : results) {
            System.out.println("");
            List<Integer> positionList = result.getPositionList();
            for (Integer position: positionList) {
                System.out.println(FOOTPRINT.repeat(position));
            }
        }
    }

}
